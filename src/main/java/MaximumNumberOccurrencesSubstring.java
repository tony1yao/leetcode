import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOccurrencesSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> stringOccurence = new HashMap<>();
        for(int i = 0; i <= s.length() - minSize; i++) {
            String subString = s.substring(i, i+minSize);
            if (numOfUniqueChars(subString) <= maxLetters) {
                stringOccurence.put(subString, stringOccurence.getOrDefault(subString, 0) + 1);
            }
        }

        int maxNumber = 0;
        for (Map.Entry<String, Integer> entry : stringOccurence.entrySet()) {
            maxNumber = Math.max(maxNumber, entry.getValue());
        }
        return maxNumber;
    }

    private int numOfUniqueChars(String s) {
        Set<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()) {
            charSet.add(c);
        }

        return charSet.size();
    }
}
