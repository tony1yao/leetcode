import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumPlatforms {

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[])
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int max = 0;
        while(p1 < arr.length) {
            if (arr[p1] < dep[p2]) {
                p1++;
                count++;
            } else {
                p2++;
                count--;
            }
            max = Math.max(count, max);
        }
        return max;

//        int nextDepTimeIndex = 0;
//        Queue<Integer> platform = new LinkedList<>();
//        int minPlatform  = 0;
//        for(int arrTime: arr) {
//            while(nextDepTimeIndex < dep.length && dep[nextDepTimeIndex] <= arrTime && !platform.isEmpty()) {
//                platform.remove();
//                nextDepTimeIndex++;
//            }
//            platform.add(arrTime);
//            minPlatform = Math.max(minPlatform, platform.size());
//        }
//        return minPlatform;
    }
}
