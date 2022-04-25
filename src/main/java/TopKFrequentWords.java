import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToFrequency = new HashMap<>();

        for(String word: words) {
            wordToFrequency.put(word, wordToFrequency.getOrDefault(word, 0) + 1);
        }

        Queue<String> queue = new PriorityQueue<>((a,b) -> {
            if(wordToFrequency.get(a) != wordToFrequency.get(b)) {
                return wordToFrequency.get(b) - wordToFrequency.get(a);
            } else {
                return a.compareTo(b);
            }
        });

        wordToFrequency.keySet().forEach(key -> queue.add(key));
        List<String> result = new ArrayList<>();
        for(int i=0; i<k; i++) {
            result.add(queue.poll());
        }
        return result;
    }
}
