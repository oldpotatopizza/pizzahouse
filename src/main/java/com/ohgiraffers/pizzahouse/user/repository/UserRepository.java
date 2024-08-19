package com.ohgiraffers.pizzahouse.user.repository;

import com.ohgiraffers.pizzahouse.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer> {



}
