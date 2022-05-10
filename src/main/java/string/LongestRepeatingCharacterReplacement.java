package string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int result = 0;
        int maxCount = 0;
        for(int i = 0; i < chars.length; i++) {
            count[chars[i] - 'A']++;
            maxCount = Math.max(maxCount, count[chars[i] - 'A']);

            if ((i - left + 1 - maxCount) > k) {
                count[chars[left] - 'A']--;
                left++;
            }
            result = Math.max(result, (i - left + 1));
        }
        return result;
    }
}
