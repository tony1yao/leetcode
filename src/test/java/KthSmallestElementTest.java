import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementTest {
    KthSmallestElement kthSmallestElement = new KthSmallestElement();

    @Test
    void kthSmallest() {
        int[] nums = {5,3,1,7,5,9,12};
        Assertions.assertEquals(1, kthSmallestElement.kthSmallest(nums, 1));
    }

    @Test
    void kthSmallest2() {
        int[] nums = {5,3,1,7,5,9,12};
        Assertions.assertEquals(5, kthSmallestElement.kthSmallest(nums, 3));
    }

    @Test
    void kthSmallest3() {
        int[] nums = {5,3,1,7,6,9,12};
        Assertions.assertEquals(7, kthSmallestElement.kthSmallest(nums, 5));
    }

    @Test
    void kthSmallest4() {
        int[] nums = {};
        Assertions.assertEquals(-1, kthSmallestElement.kthSmallest(nums, 1));
    }
}