package string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = 0;
        HashSet<Character> subString = new HashSet<>();
        char[] string = s.toCharArray();
        int start = 0, end = 0;
        for(int i = 0; i < string.length; i++) {
            if (!subString.contains(string[i])) {
                length = Math.max(length, (i - start + 1));
            } else {
                while (subString.contains(string[i])) {
                    subString.remove(string[start]);
                    start++;
                }
            }
            subString.add(string[i]);
        }
        return length;
    }
}
