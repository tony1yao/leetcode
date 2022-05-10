package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters substring = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        String s = "pwwkew";
        Assertions.assertEquals(3, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring2() {
        String s = "aaaaaaa";
        Assertions.assertEquals(1, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring3() {
        String s = "ababababababbbb";
        Assertions.assertEquals(2, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring4() {
        String s = "a";
        Assertions.assertEquals(1, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring5() {
        String s = "";
        Assertions.assertEquals(0, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring6() {
        String s = "abcabcbb";
        Assertions.assertEquals(3, substring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring7() {
        String s = "aabaab!bb";
        Assertions.assertEquals(3, substring.lengthOfLongestSubstring(s));
    }
}