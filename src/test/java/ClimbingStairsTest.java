import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    ClimbingStairs climbingStairs = new ClimbingStairs();

    @Test
    void climbStairs() {
        Assertions.assertEquals(5, climbingStairs.climbStairs(4));
    }
}