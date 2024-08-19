package com.ohgiraffers.pizzahouse.user.service;


import com.ohgiraffers.pizzahouse.user.model.UserDTO;
import com.ohgiraffers.pizzahouse.user.model.UserEntity;
import com.ohgiraffers.pizzahouse.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO userSave(UserDTO userDTO) {
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
