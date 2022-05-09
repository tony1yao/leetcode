package matrix;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        //int[][] inputs = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
         int[][] inputs = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        zeroes.setZeroes(inputs);
        System.out.println(inputs.toString());
    }
    public void setZeroes(int[][] matrix) {
        boolean zeroFirstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        zeroFirstRow = true;
                    } else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }



        if (zeroFirstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
