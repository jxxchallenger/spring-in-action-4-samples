package io.jxxchallenger.springinaction.knight;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream printStream;
    
    public SlayDragonQuest(PrintStream printStream) {
        super();
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        this.printStream.println("Embarking on quest to slay the dragon!");

    }

}
