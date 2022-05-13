package string;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int num = numOfPalindrom(s, i , i);
            result += num;
            if ((i+1)<s.length() && s.charAt(i) == s.charAt(i+1)) {
                num = numOfPalindrom(s, i, i+1);
                result += num;
            }
        }
        return result;
    }

    private int numOfPalindrom(String s, int start, int end) {
        int num = 0;
        while(start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                num++;
                start--;
                end++;
            } else {
                break;
            }
        }
        return num;
    }
}
