package model.spectator;

import model.trick.AcrobaticTrick;
import model.trick.MusicalTrick;
import model.trick.Trick;

public class Spectator implements TrickObserver {
    private String name;

    public Spectator(String name) {
        this.name = name;
    }

    @Override
    public void reactToTrick(final Trick trick, final String monkeyName) {
        if (trick instanceof AcrobaticTrick) {
            System.out.println(this.getName() + " applaudit pendant le tour d'acrobatie '" + trick.getName() + "' du singe " + monkeyName);
        } else if (trick instanceof MusicalTrick) {
            System.out.println(this.getName() + " siffle pendant le tour de musique '" + trick.getName() + "' du singe " + monkeyName);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
