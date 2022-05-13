package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringsTest {
    PalindromicSubstrings substrings = new PalindromicSubstrings();

    @Test
    void countSubstrings() {
        String s = "aaa";
        Assertions.assertEquals(6, substrings.countSubstrings(s));
    }

    @Test
    void countSubstrings1() {
        String s = "abc";
        Assertions.assertEquals(3, substrings.countSubstrings(s));
    }

    @Test
    void countSubstrings2() {
        String s = "aba";
        Assertions.assertEquals(4, substrings.countSubstrings(s));
    }

    @Test
    void countSubstrings3() {
        String s = "abba";
        Assertions.assertEquals(6, substrings.countSubstrings(s));
    }
}