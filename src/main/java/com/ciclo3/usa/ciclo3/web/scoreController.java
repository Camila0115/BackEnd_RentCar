package com.ciclo3.usa.ciclo3.web;

import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Score;
import com.ciclo3.usa.ciclo3.service.scoreService;

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
@RequestMapping("/api/Score")
public class scoreController {

    @Autowired
    private scoreService ScoreService;

    @GetMapping("/all")
    public List<Score> getAll() {
        return ScoreService.getAllScore();
    }

    @GetMapping("/{id}")
    public Optional<Score> getId(@PathVariable("id") Integer id) {
        return ScoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score Car) {
        return ScoreService.saveScore(Car);
    }
}
