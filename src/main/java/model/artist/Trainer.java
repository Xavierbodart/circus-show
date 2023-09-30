package model.artist;

public class Trainer {

    private String name;
    private Monkey monkey;

    public Trainer(String name, Monkey monkey) {
        this.name = name;
        this.monkey = monkey;
    }

    public void executeMonkeyTricks() {
        monkey.executeTricks();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
}
