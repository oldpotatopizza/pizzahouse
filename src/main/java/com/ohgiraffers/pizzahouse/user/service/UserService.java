package com.ohgiraffers.pizzahouse.user.service;


import com.ohgiraffers.pizzahouse.user.model.UserDTO;
import com.ohgiraffers.pizzahouse.user.model.UserEntity;
import com.ohgiraffers.pizzahouse.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // findbyUserName : 이름을 찾고
    // 그 이름 == 입력한 이름 사람을 가져와라
    // 그 같은 사람들 중에 주소(우편번호, 기본주소, 상세주소)가 같은 사람이 있으면
    // 중복회원입니다 라고 말해라 저장하지 말고.
    // repository 와 service 메서드의 반환타입이 같아야 한다.


    @Transactional
    public UserDTO userSave(UserDTO userDTO) {
        List<UserEntity> users = userRepository.findByUserName(userDTO.getUserName());
        if(!users.isEmpty()) {
            String targetAddress = userDTO.getAdderess() + userDTO.getAdderessDetail() + userDTO.getPostCode();
            List<UserEntity> allUser = userRepository.findAll();
            for(UserEntity user : allUser) {
                String value  = user.getAdderess() + user.getAdderessDetail() + user.getPostCode();
                if(targetAddress.equals(value)){
                    return null;
                }
            }


        }

        UserEntity userEntity = new UserEntity.Builder()
                .setUserName(userDTO.getUserName())
                .setUserAge(userDTO.getUserAge())
                .setPostCode(userDTO.getPostCode())
                .setAdderess(userDTO.getAdderess())
                .setAdderessDetail(userDTO.getAdderessDetail())
                .builder();

        userRepository.save(userEntity);


        return userDTO;


    }




}
