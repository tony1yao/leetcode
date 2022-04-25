import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarrayTest {
    MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

    @Test
    void maxProduct() {
        int[] inputs = {2,3,-2,4};
        Assertions.assertEquals(6, maximumProductSubarray.maxProduct(inputs));
    }

    @Test
    void maxProduct2() {
        int[] inputs = {-2,0,-1};
        Assertions.assertEquals(0, maximumProductSubarray.maxProduct(inputs));
    }

    @Test
    void maxProduct3() {
        int[] inputs = {-3,2,-1};
        Assertions.assertEquals(6, maximumProductSubarray.maxProduct(inputs));
    }

    @Test
    void maxProduct4() {
        int[] inputs = {-3,-1,-1};
        Assertions.assertEquals(3, maximumProductSubarray.maxProduct(inputs));
    }
}