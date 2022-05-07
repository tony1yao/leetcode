package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {
    HouseRobber houseRobber = new HouseRobber();

    @Test
    void rob1() {
        int[] nums = {1,2,3,1};
        Assertions.assertEquals(4, houseRobber.rob(nums));
    }
    @Test
    void rob2() {
        int[] nums = {2,7,9,3,1};
        Assertions.assertEquals(12, houseRobber.rob(nums));
    }

}