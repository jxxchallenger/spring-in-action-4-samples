package io.jxxchallenger.springinaction.spittr.data;

import io.jxxchallenger.springinaction.spittr.model.Spitter;

public interface SpitterRepository {

    int save(Spitter spitter);
    
    Spitter findByUsername(String username);
}
