package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
    UniquePaths uniquePaths = new UniquePaths();

    @Test
    void uniquePaths() {
        Assertions.assertEquals(3, uniquePaths.uniquePaths(3,2));
    }

    @Test
    void uniquePaths1() {
        Assertions.assertEquals(28, uniquePaths.uniquePaths(3,7));
    }

    @Test
    void uniquePaths2() {
        Assertions.assertEquals(2, uniquePaths.uniquePaths(2,2));
    }
}