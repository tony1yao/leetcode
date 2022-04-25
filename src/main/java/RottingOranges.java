import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String [] args) {
        int [][]array = {{0,1,1,2},{0,1,1,0},{1,1,2,0}};

        RottingOrangesSolution solution = new RottingOrangesSolution();
        int result = solution.orangesRotting(array);
        System.out.println(result);
    }
}


class RottingOrangesSolution {
    private int[][] directions = {{0,-1}, {1,0}, {0,1}, {-1,0}};
    int maxDis = 0;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int [][] distanceToRotton = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();


        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                    bfs(grid, distanceToRotton, queue);
                }
            }
        }

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if (grid[i][j] == 1) {
                    if (distanceToRotton[i][j] < 1) {
                        return -1;
                    } else {
                        maxDis = maxDis > distanceToRotton[i][j]? maxDis: distanceToRotton[i][j];
                    }
                }
            }
        }

        return maxDis;
    }

    private void bfs(int[][] grid, int [][] distanceToRotton, Queue<int[]> queue) {
        int distance = 1;
        int[] rotton1 = queue.peek();
        while(!queue.isEmpty()) {
            int[] rotton = queue.remove();
            for(int[] direction: directions) {
                int row = direction[0] + rotton[0];
                int col = direction[1] + rotton[1];


                if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] != 1) {
                    continue;
                }

                if (rotton[0] == rotton1[0] && rotton[1] == rotton1[1]) {
                    distance = 1;
                } else {
                    distance = distanceToRotton[rotton[0]][rotton[1]]+1;
                }

                if (distanceToRotton[row][col] > 0) {
                    if (distanceToRotton[row][col] > distance) {
                        distanceToRotton[row][col] = distance;
                        queue.add(new int[]{row, col});
                    }
                } else {
                    distanceToRotton[row][col] = distance;
                    queue.add(new int[]{row, col});
                }

            }
        }

    }
}

