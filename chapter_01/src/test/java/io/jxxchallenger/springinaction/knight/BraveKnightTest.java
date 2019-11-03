package io.jxxchallenger.springinaction.knight;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BraveKnightTest {

    @Test
    @Order(value = 1)
    void test() {
        Quest quest = Mockito.mock(Quest.class);
        Knight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
        Mockito.verify(quest, Mockito.times(1)).embark();
    }

    @Test
    @Order(value = 2)
    public void wiring() {
        Quest quest = new SlayDragonQuest(System.out);
        Knight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
    }
}
