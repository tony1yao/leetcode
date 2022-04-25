import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {
    CountPrimes countPrimes = new CountPrimes();

    @Test
    void countPrimes() {
        Assertions.assertEquals(0, countPrimes.countPrimes(-1));
    }

    @Test
    void countPrimes1() {
        Assertions.assertEquals(0, countPrimes.countPrimes(-100));
    }

    @Test
    void countPrimes2() {
        Assertions.assertEquals(0, countPrimes.countPrimes(0));
    }

    @Test
    void countPrimes3() {
        Assertions.assertEquals(4, countPrimes.countPrimes(10));
    }

    @Test
    void countPrimes4() {
        Assertions.assertEquals(25, countPrimes.countPrimes(100));
    }

    @Test
    void countPrimes5() {
        Assertions.assertEquals(0, countPrimes.countPrimes(2));
    }
}