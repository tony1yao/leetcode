import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInaString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> charOccurence = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(char c: p.toCharArray()) {
            charOccurence.put(c, charOccurence.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int length = p.length();
        int count = charOccurence.size();
        while(end < s.length()) {
            char charEnd = s.charAt(end);
            if (charOccurence.containsKey(charEnd)) {
                charOccurence.put(charEnd, charOccurence.get(charEnd) - 1);
                if (charOccurence.get(charEnd) == 0) {
                    count --;
                }
                if (count == 0) {
                    result.add(start);
                }
            }

            end++;
            if ((end - start) == length) {
                char charStart = s.charAt(start);
                if (charOccurence.containsKey(charStart)) {
                    charOccurence.put(charStart, charOccurence.get(charStart) + 1);
                    if (charOccurence.get(charStart) == 1) {
                        count ++;
                    }
                }
                start++;
            }
        }
        return result;
    }
}
