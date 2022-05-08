package Interval;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {
    NonOverlappingIntervals intervals = new NonOverlappingIntervals();

    @Test
    void eraseOverlapIntervals() {
        int[][] inputs = {{1,2},{2,3},{3,4},{1,3}};
        Assertions.assertEquals(1, intervals.eraseOverlapIntervals(inputs));
    }

    @Test
    void eraseOverlapIntervals2() {
        int[][] inputs = {{1,2},{1,2},{1,2}};
        Assertions.assertEquals(2, intervals.eraseOverlapIntervals(inputs));
    }

    @Test
    void eraseOverlapIntervals3() {
        int[][] inputs = {{1,2},{2,3}};
        Assertions.assertEquals(0, intervals.eraseOverlapIntervals(inputs));
    }
}