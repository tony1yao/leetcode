package dynamic.progromming;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isBlank() || s.charAt(0) == '0') {
            return 0;
        }
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= size; i++) {
            int oneDig = Integer.valueOf(s.substring(i-1,i));
            if (oneDig >= 1 && oneDig <=9) {
                dp[i] += dp[i-1];
            }

            int twoDigits = Integer.valueOf(s.substring(i-2,i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }

        }
        return dp[dp.length-1];
    }
}
