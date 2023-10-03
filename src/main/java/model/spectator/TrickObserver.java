package model.spectator;

import model.trick.Trick;

public interface TrickObserver {

    void reactToTrick(Trick trick, String monkeyName);

}
