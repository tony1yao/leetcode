import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {


    @Test
    void noMajority() {
        int[] inputs = {1,2,3,4,5,6};
        Assertions.assertEquals( -1 , MajorityElement.majorityElement(inputs));
    }

    @Test
    void noMajority2() {
        int[] inputs = {1,2,3,4,1,1,2,2,1};
        Assertions.assertEquals( -1 , MajorityElement.majorityElement(inputs));
    }

    @Test
    void noMajority3() {
        int[] inputs = {1,1,1,1,2,2,2,2};
        Assertions.assertEquals( -1 , MajorityElement.majorityElement(inputs));
    }

    @Test
    void emptyInput() {
        int[] inputs = {};
        Assertions.assertEquals( -1 , MajorityElement.majorityElement(inputs));
    }

    @Test
    void validInput() {
        int[] inputs = {1,2,3,2,2,2};
        Assertions.assertEquals( 2 , MajorityElement.majorityElement(inputs));
    }

    @Test
    void validInput2() {
        int[] inputs = {1,1,1,1,1,1,1,1};
        Assertions.assertEquals( 1 , MajorityElement.majorityElement(inputs));
    }
}