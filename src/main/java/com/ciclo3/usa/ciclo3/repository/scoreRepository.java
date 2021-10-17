package com.ciclo3.usa.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

import com.ciclo3.usa.ciclo3.model.Score;


@Repository
public class scoreRepository {

    @Autowired
    private scoreCrudRepository ScoreCrudRepository;

    public List<Score> getAllScore() {
        return (List<Score>) ScoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id) {
        return ScoreCrudRepository.findById(id);
    }
    public Score saveScore(Score score) {
        return ScoreCrudRepository.save(score);
    }
}
