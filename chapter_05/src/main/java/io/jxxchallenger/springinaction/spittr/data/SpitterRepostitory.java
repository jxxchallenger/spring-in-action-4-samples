package io.jxxchallenger.springinaction.spittr.data;

import io.jxxchallenger.springinaction.spittr.model.Spitter;

public interface SpitterRepostitory {

    int save(Spitter spitter);
    
    Spitter findByUsername(String username);
}
