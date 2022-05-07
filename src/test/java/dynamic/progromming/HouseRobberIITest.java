package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberIITest {
    HouseRobberII houseRobberII = new HouseRobberII();

    @Test
    void rob1() {
        int[] nums = {2,3,2};
        Assertions.assertEquals(3, houseRobberII.rob(nums));
    }
    @Test
    void rob2() {
        int[] nums = {1,2,3,1};
        Assertions.assertEquals(4, houseRobberII.rob(nums));
    }
    @Test
    void rob3() {
        int[] nums = {1,2,3};
        Assertions.assertEquals(3, houseRobberII.rob(nums));
    }

    @Test
    void rob4() {
        int[] nums = {4,2,3,6,2,3,4};
        Assertions.assertEquals(13, houseRobberII.rob(nums));
    }

    @Test
    void rob5() {
        int[] nums = {1,2,1,1};
        Assertions.assertEquals(3, houseRobberII.rob(nums));
    }
}