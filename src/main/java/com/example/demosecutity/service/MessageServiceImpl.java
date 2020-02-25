package com.example.demosecutity.service;

import com.example.demosecutity.persistence.entity.Role;
import com.example.demosecutity.persistence.repository.RoleRepository;
import com.example.demosecutity.persistence.repository.UserTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import com.example.demosecutity.persistence.entity.Message;
import com.example.demosecutity.persistence.entity.User;
import com.example.demosecutity.persistence.repository.MessageRepository;
import com.example.demosecutity.persistence.repository.UserRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;
    private final RoleRepository roleRepository;

    @Override
//    @PreAuthorize("hasRole('ROLE_USER')")
    public void add(Message msg) {
        System.out.println("msg = " + msg);
        User user = userRepository.findById(2).orElse(null);
        if (user == null) {
            log.error("something problem");
            return;
        }
//        Message message = new Message();
//        message.setContent(msg);
        msg.setUser(user);
        messageRepository.save(msg);
    }

    @Override
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Message> getAll(WebRequest webRequest) {
        Integer userId = userTokenRepository.findByToken(webRequest.getHeader("token")).getUserId();
        User user = userRepository.findById(userId).get();
        if (user.getRoles().contains("ROLE_ADMIN")) {
            return messageRepository.findAll();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
//    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Message> getAllByUser(WebRequest webRequest) {
        Integer userId = userTokenRepository.findByToken(webRequest.getHeader("token")).getUserId();
        System.out.println("userId = " + userId);
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findByName("ROLE_USER");
        List<User> users = role.getUsers();

        System.out.println("role = " + role.getUsers().size());

        System.out.println("role = " + role.getUsers().get(0).getId());


        User roleUser = users.stream().
                filter(
                user1 -> user1.getId().equals(userId))
                .findFirst().orElse(null);

        System.out.println("user = " + user.toString());
        System.out.println("roleUser = " + roleUser);
        if (roleUser != null) {
            return messageRepository.findByUser(user);
        } else {
            throw new RuntimeException();
        }
    }
}
