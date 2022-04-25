import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstringConcatenationAllWordsTest {
    SubstringConcatenationAllWords substring = new SubstringConcatenationAllWords();

    @Test
    void findSubstring() {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        int[] result = {0,9};
        Assertions.assertArrayEquals(result, substring.findSubstring(s, words).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    void findSubstring2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        int[] result = {};
        Assertions.assertArrayEquals(result, substring.findSubstring(s, words).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    void findSubstring3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        int[] result = {6,9,12};
        Assertions.assertArrayEquals(result, substring.findSubstring(s, words).stream().mapToInt(Integer::intValue).toArray());
    }
}