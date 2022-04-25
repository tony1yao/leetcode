import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return "";
        }

        if (votes.length == 1) {
            return votes[0];
        }

        int teamCount = votes[0].length();
        //last item represents team name
        //Team name will be saved in array as an integer as name - 'A';
        int [][] voteResult  =  new int[26][teamCount + 1];
        for (int i = 0; i < voteResult.length; i++) {
            voteResult[i][teamCount] = i;
        }

        for (String vote: votes) {
            for (int i = 0; i < vote.length(); i++) {
                voteResult[vote.charAt(i)-'A'][i]++;
            }
        }

        // we'll sort the result based on voteResult
        Character[] result = new Character[votes[0].length()];
        for (int i = 0; i < votes[0].length(); i++) {
            result[i] = votes[0].charAt(i);
        }
        Arrays.sort(result, (a, b) -> Arrays.compare(voteResult[b-'A'], voteResult[a-'A']));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return "";
        }

        if (votes.length == 1) {
            return votes[0];
        }

        Map<Character, TeamVote> votePerTeam = new HashMap<>();

        int numOfTeams = votes[0].length();
        int numOfVotes = votes.length;
        for (int i = 0; i < numOfTeams; i++) {
            char team = votes[0].charAt(i);
            votePerTeam.put(team, new TeamVote(team, numOfVotes));
        }

        for (int i = 0; i < numOfTeams; i++) {
            final int currentRound = i;
            for (int j = 0; j < numOfVotes ; j++) {
                String vote = votes[j];
                char voteTo = vote.charAt(i);
                votePerTeam.computeIfPresent(voteTo, (key, value) -> value.addVote(currentRound, 1));
            }
        }

        //By the end of these two loops, votePerTeam should hold the correct voting score for all teams
        List<TeamVote> teamVotes = new ArrayList<>(votePerTeam.values());
        List<Character> result = teamVotes.stream().sorted().map(teamVote -> teamVote.getTeam()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        result.forEach(team -> sb.append(team));
        return sb.toString();
    }
}

class TeamVote implements Comparable<TeamVote>{
    char team;
    int[] votes;

    public TeamVote(char team, int numberOfVote) {
        this.team = team;
        this.votes = new int[numberOfVote];
        Arrays.fill(this.votes, 0);
    }

    public char getTeam() {
        return team;
    }

    public TeamVote addVote(int round, int vote) {
        if (round >= 0 && round < this.votes.length) {
            this.votes[round] += vote;
        }
        return this;
    }

    public int[] getVotes() {
        return votes;
    }

    @Override
    public int compareTo(TeamVote o) {
        for (int i = 0 ; i < votes.length; i++) {
            if (votes[i]!= o.getVotes()[i]) {
                return o.getVotes()[i] - votes[i];
            }
        }
        return this.getTeam() - o.getTeam();
    }
}
