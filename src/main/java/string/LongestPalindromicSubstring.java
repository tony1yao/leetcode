package string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        String result = null;
        for(int i = 0; i < chars.length; i++) {
            int left = i, right = i;
            while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
            }
            left++;
            right--;
            if ((right - left + 1) > maxLength) {
                result = s.substring(left, right+1);
                maxLength = right - left + 1;
            }
            if (i+1 < chars.length && chars[i] == chars[i+1]) {
                left = i;
                right = i + 1;
                while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                if ((right - left + 1) > maxLength) {
                    result = s.substring(left, right+1);
                    maxLength = right - left + 1;
                }
            }
        }
        return result;
    }
}
