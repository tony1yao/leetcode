import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRotatedSortedArrayTest {
    SearchRotatedSortedArray sortedArray = new SearchRotatedSortedArray();

    @Test
    void search() {
        int[] nums = {3,4,5,6,7,8,9,1,2};
        Assertions.assertEquals(5, sortedArray.search(nums, 8));
        Assertions.assertEquals(-1, sortedArray.search(nums, 10));
        Assertions.assertEquals(-1, sortedArray.search(nums, -2));
    }

    @Test
    void search2() {
        int[] nums = {1,3};
        Assertions.assertEquals(1, sortedArray.search(nums, 3));
    }
    @Test
    void search3() {
        int[] nums = {5, 1,2,3,4};
        Assertions.assertEquals(1, sortedArray.search(nums, 1));
    }

    @Test
    void search4() {
        int[] nums = {4,5,6,7,8,1,2,3};
        Assertions.assertEquals(4, sortedArray.search(nums, 8));
    }

}