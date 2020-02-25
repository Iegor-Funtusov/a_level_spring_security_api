package com.example.demosecutity.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demosecutity.persistence.entity.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Integer> {

    UserToken findByToken(String token);
    UserToken findByUserId(Integer userId);
}
