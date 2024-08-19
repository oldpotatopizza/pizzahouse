package com.ohgiraffers.pizzahouse.user.controller;

import com.ohgiraffers.pizzahouse.user.model.UserDTO;
import com.ohgiraffers.pizzahouse.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {

        UserDTO userdto = userService.userSave(userDTO);

        // 한글이름 검증
        Pattern pattern = Pattern.compile("^[가-힣]+$");

        // 이름을 입력하지 않았을 때 & 헌글이름이 아닐 때
        if(userDTO.getUserName() == null || !pattern.matcher(userDTO.getUserName()).find()) {
            Map<String, String > map = new HashMap<>();
            map.put(userDTO.getUserName(), "정확한 이름을 입력하세요. ex)강형석");
            return ResponseEntity.badRequest().body(map);

            // 나이 20세 이상만 가입가능
        }else if (userDTO.getUserAge() <= 0 ){

            Map<Integer, String> map = new HashMap<>();
            map.put(userDTO.getUserAge(), "20세 이상만 가입이 가능합니다");
            return ResponseEntity.badRequest().body(map);

            // 우편번호 5자 입력필요
        }else if(String.valueOf(userDTO.getPostCode()).length() != 5  ){
            Map<Integer, String > map = new HashMap<>();
            map.put(userDTO.getPostCode(),"우편번호 5자리를 정확하게 입력하세요");

            return ResponseEntity.badRequest().body(map);

            // 기본주소 반드시 입력
        } else if (userDTO.getAdderess() == null) {

            Map<String, String > map = new HashMap<>();
            map.put(userDTO.getAdderess(), "기본주소는 필수 입력값입니다.");
            return ResponseEntity.badRequest().body(map);

            // 상세주소 반드시 입력
        } else if (userDTO.getAdderessDetail() == null) {

            Map<String, String > map = new HashMap<>();
            map.put(userDTO.getAdderessDetail(), "상세주소는 필수 입력값입니다.");
            return ResponseEntity.badRequest().body(map);
        }

        return ResponseEntity.ok(userdto);
    }




}
