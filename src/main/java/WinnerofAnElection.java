import java.util.HashMap;
import java.util.Map;

public class WinnerofAnElection {
    public String[] winner(String arr[])
    {
        Map<String, Integer> nameToVotes = new HashMap<>();
        if (arr != null) {
            if (arr.length == 0 ) {
                String[] result = {};
                return result;
            }
            for (String name: arr) {
                nameToVotes.putIfAbsent(name, 0);
                nameToVotes.put(name, nameToVotes.get(name) + 1);
            }

            int maxVote = 0;
            String nameWithMaxVote = "";
            for (String name :nameToVotes.keySet()) {
                int vote = nameToVotes.get(name);
                if (vote > maxVote) {
                    maxVote = vote;
                    nameWithMaxVote = name;
                } else if (vote == maxVote) {
                    if (name.compareTo(nameWithMaxVote) <0) {
                        nameWithMaxVote = name;
                    }
                }
            }

            String[] result = {nameWithMaxVote, String.valueOf(maxVote)};
            return result;
        }
        return null;
    }
}