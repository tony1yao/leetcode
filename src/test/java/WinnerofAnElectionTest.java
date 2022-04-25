import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerofAnElectionTest {
    WinnerofAnElection election = new WinnerofAnElection();

    @Test
    void winnerWithNullInput() {
        String[] input = null;
        Assertions.assertArrayEquals(null, election.winner(input));
    }

    @Test
    void winnerWithEmptyInput() {
        String[] input = {};
        Assertions.assertTrue(election.winner(input).length == 0);
    }

    @Test
    void winnerWithOneValue() {
        String[] input = {"tony"};
        String[] result = {"tony","1"};
        Assertions.assertArrayEquals(result, election.winner(input));
    }

    @Test
    void winnerWithTie() {
        String[] input = {"tony", "jack", "jonny", "alice"};
        String[] result = {"alice","1"};
        Assertions.assertArrayEquals(result, election.winner(input));
    }

    @Test
    void winner() {
        String[] input = {"tony", "jack", "jonny", "alice", "tony", "tony"};
        String[] result = {"tony","3"};
        Assertions.assertArrayEquals(result, election.winner(input));
    }
}