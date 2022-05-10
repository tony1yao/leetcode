package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    void groupAnagrams() {
        String [] s  = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String [] result = {};
        Assertions.assertEquals(result, groupAnagrams.groupAnagrams(s));
    }
}