import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarraySolutionTest {

    MaximumSubarraySolution maximumSubarraySolution = new MaximumSubarraySolution();
    @Test
    void maxSubArray() {
        int[] input1 = {-2,1,-3,4,-1,2,1,-5,4};
        Assertions.assertEquals(maximumSubarraySolution.maxSubArray(input1), 6);

        int[] input2 = {1};
        Assertions.assertEquals(maximumSubarraySolution.maxSubArray(input2), 1);

        int[] input3 = {-2, 1, -3};
        Assertions.assertEquals(maximumSubarraySolution.maxSubArray(input3), 1);

        int[] input4 = {1, 2, 3, 4, 5};
        Assertions.assertEquals(maximumSubarraySolution.maxSubArray(input4), 15);

        int[] input5 = {-1, -2};
        Assertions.assertEquals(maximumSubarraySolution.maxSubArray(input5), -1);
    }
}