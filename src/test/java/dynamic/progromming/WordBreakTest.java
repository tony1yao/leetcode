package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {
    WordBreak wordBreak = new WordBreak();

    @Test
    void wordBreak1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        Assertions.assertTrue(wordBreak.wordBreak(s, wordDict));
    }

    @Test
    void wordBreak2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        Assertions.assertTrue(wordBreak.wordBreak(s, wordDict));
    }

    @Test
    void wordBreak3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        Assertions.assertFalse(wordBreak.wordBreak(s, wordDict));
    }
}