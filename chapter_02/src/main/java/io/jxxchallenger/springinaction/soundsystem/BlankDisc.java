package io.jxxchallenger.springinaction.soundsystem;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlankDisc implements CompactDisc {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BlankDisc.class);

    private String title;
    
    private String artist;
    
    private List<String> tracks;
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}", title, artist);
        tracks.forEach(track -> {
            LOGGER.info(track);
        });
    }

}
