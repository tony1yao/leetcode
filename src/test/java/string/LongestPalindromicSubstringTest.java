package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring substring = new LongestPalindromicSubstring();

    @Test
    void longestPalindrome() {
        String s = "babda";
        Assertions.assertEquals("bab", substring.longestPalindrome(s));
    }

    @Test
    void longestPalindrome2() {
        String s = "cbbd";
        Assertions.assertEquals("bb", substring.longestPalindrome(s));
    }

    @Test
    void longestPalindrome3() {
        String s = "abcdedcba";
        Assertions.assertEquals("abcdedcba", substring.longestPalindrome(s));
    }
}