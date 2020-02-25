package com.example.demosecutity.controller;

import com.example.demosecutity.persistence.entity.Message;
import com.example.demosecutity.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAll(WebRequest webRequest) {
        return ResponseEntity.ok(messageService.getAll(webRequest));
    }

    @GetMapping("/all/users")
    public ResponseEntity<List<Message>> getAllByUser(WebRequest webRequest) {
        return ResponseEntity.ok(messageService.getAllByUser(webRequest));
    }
}
