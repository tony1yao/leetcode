import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {10,15,20, 6, 8, 11};
        MinCostClimbingStairsSolution solution = new MinCostClimbingStairsSolution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}

class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        } else if (cost.length == 1 || cost.length == 2) {
            return cost[cost.length - 1];
        } else {
            int[] minCost = new int[cost.length];
            Arrays.fill(minCost, Integer.MAX_VALUE);
            for(int i = 0; i < cost.length; i++) {
                if (i == 0 || i == 1) {
                    minCost[i] = cost[i];
                } else {
                    minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
                }
            }
            return Math.min(minCost[cost.length-1], minCost[cost.length-2]);
        }
    }

//    public int minCostClimbingStairs(int[] cost) {
//        int[] minCost = new int[cost.length];
//        Arrays.fill(minCost, Integer.MAX_VALUE);
//        return  Math.min(minCost(cost.length-1, cost, minCost), minCost(cost.length-2, cost, minCost));
//    }
//
//    private int minCost(int step, int[] cost, int[] minCost) {
//        if (step < 0) {
//            return 0;
//        } else if (step == 0 || step == 1) {
//            return cost[step];
//        } else {
//            int minCostStep1, minCostStep2;
//            if (minCost[step-1] < Integer.MAX_VALUE) {
//                minCostStep1 = minCost[step-1];
//            } else {
//                minCostStep1 = minCost(step-1, cost, minCost);
//                minCost[step-1] = minCostStep1;
//            }
//
//            if (minCost[step-2] < Integer.MAX_VALUE) {
//                minCostStep2 = minCost[step-2];
//            } else {
//                minCostStep2 = minCost(step-2, cost, minCost);
//                minCost[step-2] = minCostStep2;
//            }
//            return cost[step] + Math.min(minCostStep1, minCostStep2);
//        }
//    }
}