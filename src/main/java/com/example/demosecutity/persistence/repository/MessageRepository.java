package com.example.demosecutity.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demosecutity.persistence.entity.Message;
import com.example.demosecutity.persistence.entity.User;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByUser(User user);
}
