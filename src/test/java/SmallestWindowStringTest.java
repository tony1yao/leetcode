import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestWindowStringTest {

    @Test
    void smallestWindow() {
        String S = "zoomlazapzo";
        String P = "oza";
        Assertions.assertEquals("apzo", SmallestWindowString.smallestWindow(S, P));
    }

    @Test
    void smallestWindow2() {
        String S = "zoomlazapzo";
        String P = "om";
        Assertions.assertEquals("om", SmallestWindowString.smallestWindow(S, P));
    }

    @Test
    void smallestWindow3() {
        String S = "zoomlazapzo";
        String P = "zml";
        Assertions.assertEquals("mlaz", SmallestWindowString.smallestWindow(S, P));
    }

    @Test
    void smallestWindow4() {
        String S = "zoomlazapzo";
        String P = "zlp";
        Assertions.assertEquals("lazap", SmallestWindowString.smallestWindow(S, P));
    }
}