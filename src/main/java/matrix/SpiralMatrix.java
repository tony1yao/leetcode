package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        int [][] inputs = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = matrix.spiralOrder(inputs);
        System.out.println(result.toString());
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int maxCol, minCol, maxRow, minRow;
        maxCol = matrix[0].length-1;
        minCol = 0;
        maxRow = matrix.length-1;
        minRow = 0;
        direction1(matrix, 0, 0, result, maxCol, minCol, maxRow, minRow);
        return result;
    }

    private void direction1(int[][] matrix, int x, int y, List<Integer> result, int maxCol, int minCol, int maxRow, int minRow) {
        if (y <= maxCol) {
            while (y < maxCol) {
               result.add(matrix[x][y]);
               y++;
            }
            result.add(matrix[x][y]);
            minRow++;
            x++;
            direction2(matrix, x,y, result, maxCol, minCol,maxRow,minRow);
        }
    }

    private void direction2(int[][] matrix, int x, int y, List<Integer> result, int maxCol, int minCol, int maxRow, int minRow) {
        if (x <= maxRow) {
            while (x < maxRow) {
                result.add(matrix[x][y]);
                x++;
            }
            result.add(matrix[x][y]);
            maxCol--;
            y--;
            direction3(matrix, x,y, result, maxCol, minCol,maxRow,minRow);
        }
    }

    private void direction3(int[][] matrix, int x, int y, List<Integer> result, int maxCol, int minCol, int maxRow, int minRow) {
        if (y >= minCol) {
            while (y > minCol) {
                result.add(matrix[x][y]);
                y--;
            }
            result.add(matrix[x][y]);
            maxRow--;
            x--;
            direction4(matrix, x,y, result, maxCol, minCol,maxRow,minRow);
        }
    }

    private void direction4(int[][] matrix, int x, int y, List<Integer> result, int maxCol, int minCol, int maxRow, int minRow) {
        if (x >= minRow) {
            while (x > minRow) {
                result.add(matrix[x][y]);
                x--;
            }
            result.add(matrix[x][y]);
            minCol++;
            y++;
            direction1(matrix, x,y, result, maxCol, minCol,maxRow,minRow);
        }
    }
}
