package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Message;
import com.ciclo3.usa.ciclo3.service.messageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
public class messageController {

    @Autowired
    private messageService MessageService;

    @GetMapping("/all")
    public List<Message> getAll() {
        return MessageService.getAllMessage();
    }

    @GetMapping("/{id}")
    public Optional<Message> getId(@PathVariable("id") Integer id) {
        return MessageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message Car) {
        return MessageService.saveMessage(Car);
    }
}
