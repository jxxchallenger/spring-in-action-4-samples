package io.jxxchallenger.springinaction.spittr.data;

import java.util.List;

import io.jxxchallenger.springinaction.spittr.model.Spittle;

public interface SpittleRepository {
    
    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);
    
    Spittle findOne(long id);

    void save(Spittle spittle);
}
