package com.example.demosecutity.service;

import com.example.demosecutity.persistence.entity.Message;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public interface MessageService {

    void add(Message message);
    List<Message> getAll(WebRequest webRequest);
    List<Message> getAllByUser(WebRequest webRequest);
}
