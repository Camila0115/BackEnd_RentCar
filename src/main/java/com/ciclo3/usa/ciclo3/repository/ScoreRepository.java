package com.ciclo3.usa.ciclo3.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ciclo3.usa.ciclo3.model.Score;

@Repository
public class ScoreRepository {
    @Autowired
    private scoreCrudRepository crudScore;
    
    public List<Score> getAll(){
        return (List<Score>) crudScore.findAll();
    }
    public Optional <Score> getScore(int id){
        return crudScore.findById(id);
    }
    
    public Score save(Score score){
        return crudScore.save(score);
    }
    public void delete(Score score){
        crudScore.delete(score);
    }    
    
}
