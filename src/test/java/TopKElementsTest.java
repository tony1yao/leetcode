import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKElementsTest {
    TopKElements topKElements = new TopKElements();

    @Test
    void case1() {
        int[] nums = {1};
        int k = 1;
        int [] result = {1};
        Assertions.assertArrayEquals(result, topKElements.topKFrequent(nums, k));
    }

    @Test
    void case2() {
        int[] nums = {1,1,1,1,2,2,2,3,3};
        int k = 2;
        int [] result = {1,2};
        Assertions.assertArrayEquals(result, topKElements.topKFrequent(nums, k));
    }

    @Test
    void case3() {
        int[] nums = {1,2,1,2,3,4,5,6};
        int k = 2;
        int [] result = {1,2};//?
        Assertions.assertArrayEquals(result, topKElements.topKFrequent(nums, k));
    }
}