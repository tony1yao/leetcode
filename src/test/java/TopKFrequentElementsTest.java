import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {
    TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

    @Test
    void topKFrequent() {
        int[] input = {1,1,1,1,1,1,2,2,2,2,3,3,3,3,4,5,5,5,6,4};
        int[] result = {1};
        Assertions.assertArrayEquals(result, topKFrequentElements.topKFrequent(input, 1));
    }

    @Test
    void topKFrequent1() {
        int[] input = {1,1,1,1,1,1,2,2,2,2,3,3,3,3,4,5,5,5,6,4};
        int[] result = {1, 2, 3};
        Assertions.assertArrayEquals(result, topKFrequentElements.topKFrequent(input, 3));
    }

    @Test
    void topKFrequent2() {
        int[] input = {1};
        int[] result = {1};
        Assertions.assertArrayEquals(result, topKFrequentElements.topKFrequent(input, 3));
    }

    @Test
    void topKFrequent3() {
        int[] input = {1,1,1,1,1,1,2,2,2,2,3,3,3,3,4,5,5,5,6,4};
        int[] result = {1, 2, 3, 5,4, 6};
        Assertions.assertArrayEquals(result, topKFrequentElements.topKFrequent(input, 6));
    }

    @Test
    void topKFrequent4() {
        int[] input = {4,1,-1,2,-1,2,3};
        int[] result = {1, 2, 3};
        Assertions.assertArrayEquals(result, topKFrequentElements.topKFrequent(input, 3));
    }
}