import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,3,3,4,4,5,5,5};
        int k = 3;
        TopKElements topKElements = new TopKElements();

        TopKElements.miniMaxSum(List.of(256741038,623958417,467905213,714532089,938071625));
    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = arr.get(0);
        int max = arr.get(0);
        int total = arr.get(0);
        for (int i = 1; i< 5; i++) {
            int value = arr.get(i);
            min = Math.min(min, value);
            max = Math.max(max, value);
            total = total + value;
        }
        int minTotal = total - max;
        int maxTotal = total - min;
        System.out.println(minTotal + " " + maxTotal);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        //Key num; value frequency
        Map<Integer, Integer> numFrequency = new HashMap<>();

        //key frequency value a set of nums
        Map<Integer, Set<Integer>> frequencyMums = new HashMap<>();
        int[] result = new int[nums.length];
        for(int num: nums) {
            int frequency = numFrequency.getOrDefault(num, 0);
            numFrequency.put(num, frequency + 1);
            frequencyMums.getOrDefault(frequency+1, new HashSet<>()).add(num);
            Set<Integer> numSet = frequencyMums.getOrDefault(frequency, new HashSet<>());
            if (!numSet.isEmpty()) {
                numSet.remove(num);
            }

            Set<Integer> numSet2 = frequencyMums.getOrDefault(frequency + 1, new HashSet<>());
            numSet2.add(num);
            frequencyMums.put(frequency + 1, numSet2);
            if(result[frequency]>0) {
                result[frequency] --;
            }
            result[frequency+1]++;
        }

        List<Integer> count = new ArrayList<>();
        int totalCount = 0;
        for (int i = result.length-1; i >= 0; i--) {
            if (result[i] > 0) {
                count.addAll(frequencyMums.get(i));
                totalCount += result[i];
                if (totalCount == k) {
                    break;
                }
            }
        }

        return count.stream().mapToInt(Integer::intValue).toArray();
    }
//    public int[] topKFrequent(int[] nums, int k) {
//        if (k == nums.length) {
//            return nums;
//        }
//
//        Map<Integer, Integer> frequencyMapping = new HashMap<>();
//        for(int num: nums) {
//            frequencyMapping.put(num, frequencyMapping.getOrDefault(num, 0) + 1);
//        }
//
//        Queue<Integer> queue = new PriorityQueue<>((a,b) -> frequencyMapping.get(b) - frequencyMapping.get(a));
//        frequencyMapping.keySet().forEach(key -> queue.add(key));
//
//        int[] result = new int[k];
//        for(int i=0; i<k; i++) {
//            result[i] = queue.poll();
//        }
//        return result;
//    }

//    public int[] topKFrequent(int[] nums, int k) {
//        if (k == nums.length) {
//            return nums;
//        }
//
//        Map<Integer, Integer[]> frequencyMapping = new HashMap<>();
//        for(int num: nums) {
//            Integer[] frequency = frequencyMapping.get(num);
//            if (frequency == null) {
//                frequency = new Integer[]{1, num};
//                frequencyMapping.put(num, frequency);
//            } else {
//                frequency[0]++;
//            }
//        }
//
//        List<Integer[]> result = new ArrayList<>(frequencyMapping.values());
//        int[] array = result.stream().sorted((a, b) -> b[0] - a[0]).map(item -> item[1]).limit(k).mapToInt(Integer::intValue).toArray();
//
//        return array;
//    }
}
