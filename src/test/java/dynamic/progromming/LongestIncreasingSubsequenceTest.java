package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();

    @Test
    void lengthOfLIS1() {
        int[] inputs = {10,9,2,5,3,7,101,18};
        Assertions.assertEquals(4, subsequence.lengthOfLIS(inputs));
    }

    @Test
    void lengthOfLIS2() {
        int[] inputs = {0,1,0,3,2,3};
        Assertions.assertEquals(4, subsequence.lengthOfLIS(inputs));
    }

    @Test
    void lengthOfLIS3() {
        int[] inputs = {7,7,7,7,7,7,7};
        Assertions.assertEquals(1, subsequence.lengthOfLIS(inputs));
    }

    @Test
    void lengthOfLIS4() {
        int[] inputs = {-7-10,-5,0,7,1,2,8};
        Assertions.assertEquals(6, subsequence.lengthOfLIS(inputs));
    }
}