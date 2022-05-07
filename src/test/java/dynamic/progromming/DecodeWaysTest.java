package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {
    DecodeWays decodeWays = new DecodeWays();

    @Test
    void numDecodings() {
        String s = "12";
        Assertions.assertEquals(2, decodeWays.numDecodings(s));
    }

    @Test
    void numDecodings2() {
        String s = "226";
        Assertions.assertEquals(3, decodeWays.numDecodings(s));
    }

    @Test
    void numDecodings3() {
        String s = "06";
        Assertions.assertEquals(0, decodeWays.numDecodings(s));
    }

    @Test
    void numDecodings4() {
        String s = "2611055971756562";
        Assertions.assertEquals(4, decodeWays.numDecodings(s));
    }
}