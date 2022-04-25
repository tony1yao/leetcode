import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankTeamsByVotesTest {
    RankTeamsByVotes rankTeamsByVotes;
    @BeforeEach
    void setUp() {
        rankTeamsByVotes = new RankTeamsByVotes();
    }

    @Test
    void case1() {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "BAC"};
        Assertions.assertEquals("ABC", rankTeamsByVotes.rankTeams(votes));
    }

    @Test
    void case2() {
        //Should return "ABCDEFG"
        String[] votes = {"ABCDEFG"};
        Assertions.assertEquals("ABCDEFG", rankTeamsByVotes.rankTeams(votes));
    }

    @Test
    void case3() {
        //Should return ""
        String[] votes = {""};
        Assertions.assertEquals("", rankTeamsByVotes.rankTeams(votes));
    }

    @Test
    void case4() {
        //Should return "ABCD"
        String[] votes = {"ABCD", "BACD", "CABD"};
        Assertions.assertEquals("ABCD", rankTeamsByVotes.rankTeams(votes));
    }
}