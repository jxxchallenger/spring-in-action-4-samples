package io.jxxchallenger.springinaction.spittr.data.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import io.jxxchallenger.springinaction.spittr.data.SpittleRepository;
import io.jxxchallenger.springinaction.spittr.model.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private NamedParameterJdbcOperations namedParameterJdbcOperations;
    
    private SimpleJdbcInsertOperations simpleJdbcInsertOperations;
    
    @Autowired
    public JdbcSpittleRepository(NamedParameterJdbcOperations namedParameterJdbcOperations, DataSource dataSource) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.simpleJdbcInsertOperations = new SimpleJdbcInsert(dataSource).withTableName("spittle").usingGeneratedKeyColumns("id");
    }
    
    @Override
    public List<Spittle> findRecentSpittles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        
        MapSqlParameterSource paramSource = new MapSqlParameterSource("max", max);
        paramSource.addValue("count", count);
        return this.namedParameterJdbcOperations.query("SELECT id, message, `time`, latitude, longitude FROM spittle WHERE id < :max ORDER BY `time` DESC LIMIT :count", paramSource, (rs, num) -> {
            return new Spittle(rs.getLong(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), rs.getDouble(4), rs.getDouble(5));
        });
    }

    //@Cacheable(value = {"spittleCache"})
    @Override
    public Spittle findOne(long id) {
        
        return this.namedParameterJdbcOperations.queryForObject("SELECT id, message, `time`, latitude, longitude FROM spittle WHERE id = :id", new MapSqlParameterSource("id", id), (rs, num) -> {
            return new Spittle(rs.getLong(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), rs.getDouble(4), rs.getDouble(5));
        });
    }

    @Override
    public Spittle save(Spittle spittle) {
        Number number = this.simpleJdbcInsertOperations.executeAndReturnKey(new BeanPropertySqlParameterSource(spittle));
        spittle.setId(number.longValue());
        return spittle;
    }

    @Override
    public void remove(long id) {
        this.namedParameterJdbcOperations.update("DELETE FROM spittle WHERE id = :id", new MapSqlParameterSource("id", id));
        
    }

    
}
