import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {
    RotateArray rotateArray = new RotateArray();

    @Test
    void rotate() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] result = {5,6,7,1,2,3,4};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate2() {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        int[] result = {3,99,-1,-100};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate3() {
        int[] nums = {-1,-100,3,99};
        int k = 0;
        int[] result = {-1,-100,3,99};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate4() {
        int[] nums = {-1,-100,3,99};
        int k = 4;
        int[] result = {-1,-100,3,99};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate5() {
        int[] nums = {-1,-100,3,99};
        int k = 5;
        int[] result = {99, -1,-100,3};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate6() {
        int[] nums = {-1};
        int k = 5;
        int[] result = {-1};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }

    @Test
    void rotate7() {
        int[] nums = {};
        int k = 5;
        int[] result = {};
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }
}