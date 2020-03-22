package io.jxxchallenger.springinaction.spittr.data.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import io.jxxchallenger.springinaction.spittr.data.SpitterRepostitory;
import io.jxxchallenger.springinaction.spittr.model.Spitter;

@Repository
public class JdbcSpitterRepostitory implements SpitterRepostitory {

    private NamedParameterJdbcOperations namedParameterJdbcOperations;
    
    private SimpleJdbcInsertOperations simpleJdbcInsertOperations;
    
    @Autowired
    public JdbcSpitterRepostitory(NamedParameterJdbcOperations namedParameterJdbcOperations, DataSource dataSource) {
        super();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.simpleJdbcInsertOperations = new SimpleJdbcInsert(dataSource).withTableName("spitter").usingGeneratedKeyColumns("id");
    }

    @Override
    public int save(Spitter spitter) {
        return this.simpleJdbcInsertOperations.execute(new BeanPropertySqlParameterSource(spitter));
    }

    @Override
    public Spitter findByUsername(String username) {
        return this.namedParameterJdbcOperations.queryForObject("SELECT id, first_name, last_name, username, password, email FROM  spitter WHERE username = :username", new MapSqlParameterSource("username", username), (rs, num) -> {
            return new Spitter(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        });
    }

    
}
