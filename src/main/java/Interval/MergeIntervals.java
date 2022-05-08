package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] preInterval = list.get(list.size()-1);
            int[] currentInterval = intervals[i];
            if (currentInterval[0] > preInterval[1]) {
                list.add(currentInterval);
            } else {
                int newEndIndex = Math.max(preInterval[1], currentInterval[1]);
                int[] newInterval = {preInterval[0], newEndIndex};
                list.set(list.size()-1, newInterval);
            }
        }
        int[][] intArray = new int[list.size()][];
        return list.toArray(intArray);
    }
}
