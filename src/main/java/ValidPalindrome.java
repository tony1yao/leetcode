//public class ValidPalindrome {
//    public static void main(String [] args) {
//        String s = "";
//        Solution solution = new Solution();
//        solution.validPalindrome();
//    }
//}
//
//class Solution {
//    public boolean validPalindrome(String s) {
//        int left = 0;
//        int right = s.length()-1;
//        boolean alreadyRemovedOne = false;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                boolean isPalindrome = isPalindrome(s.substring(left+1, right+1));
//                if(isPalindrome) {
//                    return true;
//                } else {
//                    return isPalindrome(s.substring(left, right));
//                }
//                // if (s.charAt(left+1) == s.charAt(right) && !alreadyRemovedOne) {
//                //     left++;
//                //     alreadyRemovedOne = true;
//                // } else if (s.charAt(left) == s.charAt(right-1) && !alreadyRemovedOne) {
//                //     right--;
//                //     alreadyRemovedOne = true;
//                // } else {
//                //     return false;
//                // }
//            } else {
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
//
//    public boolean isPalindrome(String s) {
//        int left = 0;
//        int right = s.length()-1;
//        while(left<right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            } else {
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
//}
