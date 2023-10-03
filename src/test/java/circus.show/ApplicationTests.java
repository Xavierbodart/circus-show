package circus.show;

import model.artist.Monkey;
import model.artist.Trainer;
import model.spectator.Spectator;
import model.trick.AcrobaticTrick;
import model.trick.MusicalTrick;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

public class ApplicationTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    //Redirect standard output stream to a local one
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //Restore output stream
    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testSpectatorReactsOnAcrobaticTrick() {
        final AcrobaticTrick bobTrick = new AcrobaticTrick("marcher sur les mains");
        final Monkey bobTheMonkey = new Monkey("Bob", Collections.singletonList(bobTrick));
        final Trainer bobsTrainer = new Trainer("Jammy", bobTheMonkey);
        final Spectator spectator = new Spectator("Spectateur");
        bobTheMonkey.addObserver(spectator);
        bobsTrainer.executeMonkeyTricks();
        String consoleOutput = outContent.toString().trim(); // Get console output
        Assertions.assertEquals("Spectateur applaudit pendant le tour d'acrobatie 'marcher sur les mains' du singe " +
                "Bob", consoleOutput);
    }

    @Test
    public void testSpectatorReactsOnMusicalTrick() {
        final MusicalTrick bobTrick = new MusicalTrick("jouer du piano");
        final Monkey bobTheMonkey = new Monkey("Bob", Collections.singletonList(bobTrick));
        final Trainer bobsTrainer = new Trainer("Jammy", bobTheMonkey);
        final Spectator spectator = new Spectator("Spectateur");
        bobTheMonkey.addObserver(spectator);
        bobsTrainer.executeMonkeyTricks();
        String consoleOutput = outContent.toString().trim(); // Get console output
        Assertions.assertEquals("Spectateur siffle pendant le tour de musique 'jouer du piano' du singe Bob",
                consoleOutput);
    }

    @Test
    public void testSpectatorReactsOnNoTrick() {
        final Monkey bobTheMonkey = new Monkey("Bob", null);
        final Trainer bobsTrainer = new Trainer("Jammy", bobTheMonkey);
        final Spectator spectator = new Spectator("Spectateur");
        bobTheMonkey.addObserver(spectator);
        bobsTrainer.executeMonkeyTricks();
        String consoleOutput = outContent.toString().trim(); // Get console output
        Assertions.assertEquals("",
                consoleOutput);
    }
}