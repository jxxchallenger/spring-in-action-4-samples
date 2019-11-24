package io.jxxchallenger.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;
    
    @Autowired
    public CDPlayer(CompactDisc compactDisc) {
        super();
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        this.compactDisc.play();
    }

}
