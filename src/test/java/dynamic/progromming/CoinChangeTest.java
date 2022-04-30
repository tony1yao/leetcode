package dynamic.progromming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {
    CoinChange coinChange = new CoinChange();

    @Test
    void coinChange1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Assertions.assertEquals(3, coinChange.coinChange(coins, amount));
    }

    @Test
    void coinChange2() {
        int[] coins = {1, 2, 5};
        int amount = 3;
        Assertions.assertEquals(2, coinChange.coinChange(coins, amount));
    }

    @Test
    void coinChange3() {
        int[] coins = {1, 2, 5, 10};
        int amount = 27;
        Assertions.assertEquals(4, coinChange.coinChange(coins, amount));
    }

    @Test
    void coinChange4() {
        int[] coins = {1};
        int amount = 0;
        Assertions.assertEquals(0, coinChange.coinChange(coins, amount));
    }

    @Test
    void coinChange5() {
        int[] coins = {2, 5, 10};
        int amount = 11;
        Assertions.assertEquals(4, coinChange.coinChange(coins, amount));
    }
}