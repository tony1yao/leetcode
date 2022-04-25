import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOccurrencesSubstringTest {
    MaximumNumberOccurrencesSubstring numberOccurrencesSubstring = new MaximumNumberOccurrencesSubstring();

    @Test
    void maxFreq() {
        Assertions.assertEquals(2, numberOccurrencesSubstring.maxFreq("aababcaab", 2, 3, 4));
    }
}