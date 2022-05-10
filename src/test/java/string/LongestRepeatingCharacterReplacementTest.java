package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {
    LongestRepeatingCharacterReplacement replacement = new LongestRepeatingCharacterReplacement();

    @Test
    void characterReplacement() {
        String s = "ABAB";
        int k = 2;
        Assertions.assertEquals(4, replacement.characterReplacement(s,k));
    }

    @Test
    void characterReplacement1() {
        String s = "AABABBA";
        int k = 1;
        Assertions.assertEquals(4, replacement.characterReplacement(s,k));
    }
}