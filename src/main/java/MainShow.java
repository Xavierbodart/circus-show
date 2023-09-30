import model.artist.Monkey;
import model.artist.Trainer;
import model.spectator.Spectator;
import model.trick.AcrobaticTrick;
import model.trick.MusicalTrick;
import model.trick.Trick;

import java.util.Arrays;
import java.util.List;

public class MainShow {

    public static void main(String[] args) {
        final List<Trick> bobTricks = Arrays.asList(new AcrobaticTrick("marcher sur les mains"),
                new MusicalTrick("frapper les cymbales"));
        final List<Trick> aliceTricks = Arrays.asList(new MusicalTrick("jouer du trombone"),
                new AcrobaticTrick("faire un saut périlleux"), new MusicalTrick("jouer au piano"));

        final Monkey bobTheMonkey = new Monkey("Bob", bobTricks);
        final Monkey aliceTheMonkey = new Monkey("Alice", aliceTricks);

        final Trainer bobsTrainer = new Trainer("Jammy", bobTheMonkey);
        final Trainer alicesTrainer = new Trainer("Charles", aliceTheMonkey);

        final Spectator spectator = new Spectator("Spectateur");

        bobTheMonkey.addObserver(spectator);
        aliceTheMonkey.addObserver(spectator);

        bobsTrainer.executeMonkeyTricks();
        alicesTrainer.executeMonkeyTricks();
    }
}
