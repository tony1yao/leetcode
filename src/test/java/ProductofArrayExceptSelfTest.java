import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductofArrayExceptSelfTest {
    ProductofArrayExceptSelf productofArrayExceptSelf = new ProductofArrayExceptSelf();

    @Test
    void productExceptSelf() {
        int[] input = {1,2,3,4};
        int[] result = {24,12,8,6};
        Assertions.assertArrayEquals(result, productofArrayExceptSelf.productExceptSelf(input));
    }

    @Test
    void productExceptSelf2() {
        int[] input = {-1,1,0,-3,3};
        int[] result = {0,0,9,0,0};
        Assertions.assertArrayEquals(result, productofArrayExceptSelf.productExceptSelf(input));
    }
}