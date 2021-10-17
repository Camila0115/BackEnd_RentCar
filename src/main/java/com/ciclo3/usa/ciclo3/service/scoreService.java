package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Score;
import com.ciclo3.usa.ciclo3.repository.scoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class scoreService {
    
    @Autowired
    private scoreRepository ScoreRepository;

    public List<Score> getAllScore() {
        return (List<Score>) ScoreRepository.getAllScore();
    }
    public Optional<Score> getScore(int id) {
        return ScoreRepository.getScore(id);
    }
    public Score saveScore(Score score) {
        if(score.getId() == null){
            return ScoreRepository.saveScore(score);
        }
        else{
            Optional<Score> scoreAux = ScoreRepository.getScore(score.getId());
            if(scoreAux.isEmpty()){
                return ScoreRepository.saveScore(score); 
            }else{
                return score;
            }
        }
        
    }
}
