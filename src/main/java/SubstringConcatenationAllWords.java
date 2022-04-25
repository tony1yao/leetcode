import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> stringMap = new HashMap<>();
        for(String word: words) {
            stringMap.put(word, stringMap.getOrDefault(word, 0) + 1);
        }

        int start = 0;

        return new ArrayList<Integer>();
    }
}
