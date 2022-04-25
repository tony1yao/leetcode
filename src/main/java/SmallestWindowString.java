import java.util.HashMap;
import java.util.Map;

public class SmallestWindowString {

    public static String smallestWindow(String s, String t)
    {
        // Your code here
        Map<Character, Integer> pMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int counter = pMap.size();
        int len = Integer.MAX_VALUE;
        String result = "";
        while (end < s.length()) {
            char c = s.charAt(end);
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) -1);
                if (pMap.get(c) == 0) {
                    counter--;
                }
            }
            end++;


            while(counter == 0) {
                if ((end - start) < len) {
                    len = end - start;
                    result = s.substring(start, end);
                }
                // we got a valid string
                // start to trim from the starting point
                char startChar = s.charAt(start);
                if (pMap.containsKey(startChar)) {
                    pMap.put(startChar, pMap.get(startChar) + 1);
                    if (pMap.get(startChar) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }

        return result;
    }
}
