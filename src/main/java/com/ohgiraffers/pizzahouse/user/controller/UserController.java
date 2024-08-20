package com.ohgiraffers.pizzahouse.user.controller;

import com.ohgiraffers.pizzahouse.user.model.UserDTO;
import com.ohgiraffers.pizzahouse.user.model.UserEntity;
import com.ohgiraffers.pizzahouse.user.repository.UserRepository;
import com.ohgiraffers.pizzahouse.user.service.UserService;
import com.ohgiraffers.pizzahouse.utill.Utills;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> createUser(@RequestBody UserDTO userDTO) {
        Map<String, Object> map = new HashMap<>();


        // 이름을 입력하지 않았을 때 & 헌글이름이 아닐 때
        if (userDTO.getUserName() == null || !Utills.regex(userDTO.getUserName())) {
            map.put("error", "정확한 이름을 입력하세요. ex)강형석");
            return ResponseEntity.status(400).body(map);

            // 나이 20세 이상만 가입가능
        } else if (userDTO.getUserAge() < 20) {

            map.put("error", "20세 이상만 가입이 가능합니다");
            return ResponseEntity.status(400).body(map);

            // 우편번호 5자 입력필요
        } else if (String.valueOf(userDTO.getPostCode()).length() != 5) {

            map.put("error", "우편번호 5자리를 정확하게 입력하세요");

            return ResponseEntity.status(400).body(map);

            // 기본주소 반드시 입력
        } else if (userDTO.getAdderess().isEmpty() || userDTO.getAdderess() == null) {

            map.put("error", "기본주소는 필수 입력값입니다.");
            return ResponseEntity.status(400).body(map);

            // 상세주소 반드시 입력
        } else if (userDTO.getAdderessDetail().isEmpty() || userDTO.getAdderessDetail() == null) {

            map.put("error", "상세주소는 필수 입력값입니다.");
            return ResponseEntity.status(400).body(map);
        }
        userService.userSave(userDTO);
        map.put("success","회원등록이 완료되었습니다");
        return ResponseEntity.status(201).body(map);
    }
    @GetMapping("/")
    public ResponseEntity<Map<String,Object>> getAllUsers() {
        Map<String, Object> map = new HashMap<>();

        List<UserDTO> userDTOList = userService.getAllUser();
        if (userDTOList != null) {
            map.put("userInfo", userDTOList);
            return ResponseEntity.ok(map);
        }else {
            map.put("error","데이터가 없습니다.");
            return ResponseEntity.status(400).body(map);
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Map<String,Object>> detailUser( @PathVariable Integer userId){
        Map<String,Object> map = new HashMap<>();

        if (userId <=0 || userId == null) {
            map.put(" error ", "다시 시도해주세요.");
            return ResponseEntity.status(400).body(map);
        }

        UserDTO findDTO = userService.detailUser(userId);
        if (findDTO != null) {
            map.put("UserInfo", findDTO);
            return ResponseEntity.status(201).body(map);
        }
        else {
            map.put("error", "조회실패");
            return ResponseEntity.status(400).body(map);
        }
        }



}
