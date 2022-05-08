package Interval;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {
    MergeIntervals mergeIntervals = new MergeIntervals();

    @Test
    void merge() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expectedResult = {{1,6},{8,10},{15,18}};
        int [][] result = mergeIntervals.merge(intervals);
        System.out.println(result.toString());
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    void merge2() {
        int[][] intervals = {{1,4},{4,5}};
        int[][] expectedResult = {{1,5}};
        Assertions.assertArrayEquals(expectedResult, mergeIntervals.merge(intervals));
    }
}