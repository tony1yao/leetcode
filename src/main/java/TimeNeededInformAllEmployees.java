import java.util.*;

public class TimeNeededInformAllEmployees {
    public static void main(String [] args) {
        char [][]lands = {"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};

        TimeNeededInformAllEmployeesSolution solution = new TimeNeededInformAllEmployeesSolution();
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        int result = solution.numOfMinutes(7, 6, manager, informTime);
        System.out.println(result);
    }
}


//7
//6
//[1,2,3,4,5,6,-1]
//[0,6,5,4,3,2,1]


class TimeNeededInformAllEmployeesSolution {
    int maxMinus = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();


        for (int i = 0; i < manager.length; i++) {
            if (i != headID) {
                int managerId = manager[i];
                if (graph.get(managerId) == null) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    graph.put(managerId, sub);
                } else {
                    graph.get(managerId).add(i);
                }
            }
        }


        Set<Integer> seen = new HashSet<>();
        dfs(headID, graph, informTime, 0, seen);
        return maxMinus;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, int[] informTime, int mins, Set<Integer> seen) {
        if (!seen.contains(node)) {
            int time = mins + informTime[node];
            maxMinus = maxMinus > time? maxMinus: time;
            seen.add(node);
            List<Integer> children = graph.get(node);
            if (children != null) {
                for(Integer child: children) {
                    if (informTime[child] != 0) {
                        dfs(child, graph, informTime, time, seen);
                    }
                }
            }
        }
    }
}