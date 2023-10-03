package model.artist;

import model.spectator.TrickObserver;
import model.trick.Trick;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private String name;
    private List<Trick> tricks;
    private List<TrickObserver> trickObservers = new ArrayList<>();

    public Monkey(String name, List<Trick> tricks) {
        this.name = name;
        this.tricks = tricks;
    }

    public void addObserver(final TrickObserver observer) {
        this.trickObservers.add(observer);
    }

    protected void executeTricks() {
        if (tricks != null) {
            for (Trick trick : tricks) {
                notifyObservers(trick);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public List<TrickObserver> getTrickObservers() {
        return trickObservers;
    }

    public void setTrickObservers(List<TrickObserver> trickObservers) {
        this.trickObservers = trickObservers;
    }

    private void notifyObservers(final Trick trick) {
        if (trickObservers != null) {
            for (TrickObserver observer : trickObservers) {
                observer.reactToTrick(trick, this.getName());
            }
        }
    }
}
