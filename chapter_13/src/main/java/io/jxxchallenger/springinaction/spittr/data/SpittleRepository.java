package io.jxxchallenger.springinaction.spittr.data;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import io.jxxchallenger.springinaction.spittr.model.Spittle;

public interface SpittleRepository {
    
    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);
    
    @Cacheable(value = {"spittleCache"})
    Spittle findOne(long id);

    @CachePut(value = {"spittleCache"}, key = "#result.id")
    Spittle save(Spittle spittle);
    
    @CacheEvict(value = {"spittleCache"})
    void remove(long id);
}
