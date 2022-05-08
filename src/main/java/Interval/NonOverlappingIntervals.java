package Interval;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        int result = 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int[] preInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] < preInterval[1]) {
                result++;
                if (currentInterval[1] < preInterval[1]) {
                    preInterval = currentInterval;
                }
            } else {
                preInterval = currentInterval;
            }
        }
        return result;
    }
}
