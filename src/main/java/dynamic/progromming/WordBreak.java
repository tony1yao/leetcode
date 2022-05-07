package dynamic.progromming;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dict =  wordDict.stream().collect(Collectors.toMap(e->e,e->true));
        boolean dp[] = new boolean[s.length()];
        Arrays.fill(dp, false);
        for(int i = s.length() -1 ; i>=0; i--) {
            String subString = s.substring(i);
            if (dict.getOrDefault(subString, false)) {
                dp[i]  = true;
            } else {
                for (int j = s.length() -1; j >= i; j-- ) {
                    if (dp[j]) {
                        String newSub = s.substring(i, j);
                        if (dict.getOrDefault(newSub, false)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0];
//
//        Queue<WordDetails> queue = new LinkedList<>();
//        Set<Integer> visited = new HashSet<>();
//
//        for(int i = 1; i <= s.length(); i ++) {
//            queue.add(new WordDetails(s.substring(0, i), i - 1));
//        }
//
//        while(!queue.isEmpty()) {
//            WordDetails wordDetails = queue.remove();
//            String word = wordDetails.getWord();
//            if (dict.getOrDefault(word, false)) {
//                if (wordDetails.getLastIndex() == s.length() - 1) {
//                    return true;
//                } else {
//                    int nextIndex = wordDetails.getLastIndex() + 1;
//                    if (!visited.contains(nextIndex)) {
//                        for (int i = nextIndex; i < s.length(); i ++) {
//                            queue.add(new WordDetails(s.substring(nextIndex, i+1), i));
//                        }
//                        visited.add(nextIndex);
//                    }
//                }
//            }
//        }
//        return false;
    }
}

class WordDetails {
    private final String word;
    private final int lastIndex;

    public WordDetails(String word, int lastIndex) {
        this.word = word;
        this.lastIndex = lastIndex;
    }

    public String getWord() {
        return word;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
