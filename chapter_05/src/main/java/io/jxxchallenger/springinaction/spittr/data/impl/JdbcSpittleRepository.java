package io.jxxchallenger.springinaction.spittr.data.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import io.jxxchallenger.springinaction.spittr.data.SpittleRepository;
import io.jxxchallenger.springinaction.spittr.model.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
    
    @Override
    public List<Spittle> findRecentSpittles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        
        return this.namedParameterJdbcOperations.query("SELECT id, message, `time`, latitude, longitude FROM spittle WHERE id < :max ORDER BY `time` DESC LIMIT 20", new MapSqlParameterSource("max", max), (rs, num) -> {
            return new Spittle(rs.getLong(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), rs.getDouble(4), rs.getDouble(5));
        });
    }

    @Override
    public Spittle findOne(long id) {
        
        return this.namedParameterJdbcOperations.queryForObject("SELECT id, message, `time`, latitude, longitude FROM spittle WHERE id = :id", new MapSqlParameterSource("id", id), (rs, num) -> {
            return new Spittle(rs.getLong(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), rs.getDouble(4), rs.getDouble(5));
        });
    }

    @Override
    public void save(Spittle spittle) {
        this.namedParameterJdbcOperations.update("INSERT INTO spittle (message, `time`, latitude, longitude) values (:message, :time, :latitude, :longitude)", new BeanPropertySqlParameterSource(spittle));
        
    }

    
}
