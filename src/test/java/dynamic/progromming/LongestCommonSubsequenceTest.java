package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    LongestCommonSubsequence subsequence = new LongestCommonSubsequence();

    @Test
    void longestCommonSubsequence1() {
        String text1 = "abcde";
        String text2 = "ace";
        Assertions.assertEquals(3, subsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestCommonSubsequence2() {
        String text1 = "abcde";
        String text2 = "cae";
        Assertions.assertEquals(2, subsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestCommonSubsequence3() {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        Assertions.assertEquals(1, subsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestCommonSubsequence4() {
        String text1 = "bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq";
        String text2 = "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx";
        Assertions.assertEquals(13, subsequence.longestCommonSubsequence(text1, text2));
    }
}