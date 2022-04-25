public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 ) {
                return false;
            } else if ( x < 10) {
                return true;
            } else if (x == 10) {
                return false;
            } else {
                var lastDigits = x % 10;
                var firstDigits = x / 10;
                var digitsMoved = 1;
                while (firstDigits >= Math.pow(10, digitsMoved - 1)) {
                    if (firstDigits == lastDigits) {
                        return true;
                    }
                    var lastDig = firstDigits % 10;
                    firstDigits = firstDigits / 10;
                    if (firstDigits == lastDigits) {
                        return true;
                    }
                    lastDigits = lastDigits * 10 + lastDig;
                    digitsMoved++;
                }
                return false;
            }
        }
    }
}


