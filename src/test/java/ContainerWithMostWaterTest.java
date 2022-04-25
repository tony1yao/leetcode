import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {
    ContainerWithMostWater mostWater = new ContainerWithMostWater();

    @Test
    void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Assertions.assertEquals(49, mostWater.maxArea(height));
    }

    @Test
    void maxArea2() {
        int[] height = {1,1};
        Assertions.assertEquals(1, mostWater.maxArea(height));
    }

    @Test
    void maxArea3() {
        int[] height = {1,8,6,2,5,4,8,3,5};
        Assertions.assertEquals(40, mostWater.maxArea(height));
    }
}