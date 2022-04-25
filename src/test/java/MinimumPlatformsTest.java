import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPlatformsTest {

    @Test
    void findPlatform() {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        Assertions.assertEquals(3, MinimumPlatforms.findPlatform(arr, dep));
    }

    @Test
    void findPlatform2() {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};
        Assertions.assertEquals(1, MinimumPlatforms.findPlatform(arr, dep));
    }

    @Test
    void findPlatform3() {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1100, 1235, 1240};
        Assertions.assertEquals(1, MinimumPlatforms.findPlatform(arr, dep));
    }

    @Test
    void findPlatform4() {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1100, 1235, 1240};
        Assertions.assertEquals(1, MinimumPlatforms.findPlatform(arr, dep));
    }
}