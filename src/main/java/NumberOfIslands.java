import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String [] args) {
        char [][]lands = {"11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()};

        Solution1 solution = new Solution1();
        int result = solution.numIslands(lands);
        System.out.println(result);
    }
}


class Solution1 {
    private int[][] directions = {{0,-1}, {1,0}, {0,1}, {-1,0}};

    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i< row;i++) {
            for(int j=0;j<col;j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i,j});
                    bfs(grid, queue);
                }
            }
        }
        return numOfIsland;
    }

    private void bfs(char[][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] land = queue.remove();
            for (int[] direction : directions) {
                int row = land[0] + direction[0];
                int col = land[1] + direction[1];
                if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
                    continue;
                }
                grid[row][col] = '0';
                queue.add(new int[]{row, col});
            }
        }
    }
}