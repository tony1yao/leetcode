package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {
    JumpGame jumpGame = new JumpGame();

    @Test
    void canJump() {
        int[] nums = {2,3,1,1,4};
        Assertions.assertTrue(jumpGame.canJump(nums));
    }

    @Test
    void canJump1() {
        int[] nums = {3,2,1,0,4};
        Assertions.assertFalse(jumpGame.canJump(nums));
    }

    @Test
    void canJump2() {
        int[] nums = {0,2,3};
        Assertions.assertFalse(jumpGame.canJump(nums));
    }
}