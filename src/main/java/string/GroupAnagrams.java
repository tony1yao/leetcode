package string;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Integer, List<String>> stringGroup = Arrays.stream(strs)
//                .collect(groupingBy(s->getStringValue(s)));


        Map<String, List<String>> stringGroup = new HashMap<>();
        for(String s: strs) {
            List<String> list = stringGroup.getOrDefault(getStringValue(s), new ArrayList<>());
            list.add(s);
            stringGroup.put(getStringValue(s), list);
        }
        return new ArrayList<>(stringGroup.values());
    }

    private String getStringValue(String s) {
        char[] string = s.toCharArray();
        Arrays.sort(string);
        return String.valueOf(string);
    }
}
