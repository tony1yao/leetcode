import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    ReverseInteger reverseInteger = new ReverseInteger();
    @Test
    void reverse() {
        int input = 1;
        Assertions.assertEquals(1, reverseInteger.reverse(input));
    }

    @Test
    void reverse2() {
        int input = 12;
        Assertions.assertEquals(21, reverseInteger.reverse(input));
    }

    @Test
    void reverse3() {
        int input = -135;
        Assertions.assertEquals(-531, reverseInteger.reverse(input));
    }

    @Test
    void reverse4() {
        int input = 1111111;
        Assertions.assertEquals(1111111, reverseInteger.reverse(input));
    }

    @Test
    void reverse5() {
        int input = 123450;
        Assertions.assertEquals(54321, reverseInteger.reverse(input));
    }

    @Test
    void reverse6() {
        int input = 2137383648;
        Assertions.assertEquals(0, reverseInteger.reverse(input));
    }
}