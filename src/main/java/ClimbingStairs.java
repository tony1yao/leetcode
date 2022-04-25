public class ClimbingStairs {
    int[] waysOfStep;
    public int climbStairs(int n) {
        waysOfStep = new int[n];
        return waysOfSteps(n);
    }

    private int waysOfSteps(int n) {
        if (n <= 3){
            waysOfStep[n-1] = n;
            return n;
        } else {
            if (waysOfStep[n-3] == 0) {
                waysOfStep[n-3] = waysOfSteps(n-2);
            }
            if (waysOfStep[n-2] == 0) {
                waysOfStep[n-2] = waysOfSteps(n-1);
            }
            return waysOfStep[n-3] + waysOfStep[n-2];
        }
    }
}
