import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for(int num: nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<Integer>((a,b)->numToFrequency.get(b)- numToFrequency.get(a));
        numToFrequency.keySet().forEach(key -> queue.add(key));
        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = queue.poll();
        }
        return result;
        // return queue.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
