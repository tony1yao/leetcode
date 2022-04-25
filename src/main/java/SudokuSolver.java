import java.util.*;

public class SudokuSolver {
}


class SudokuSolverSolution {
    char[] values = "0123456789".toCharArray();
    public void solveSudoku(char[][] board) {
        int size = board.length;
        List<Set<Character>> boxes = new ArrayList<>();
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (rows.size() > i && rows.get(i) != null) {
                    rows.get(i).add(board[i][j]);
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    rows.add(set);
                }

                if (cols.size() > j && cols.get(j) != null) {
                    cols.get(j).add(board[i][j]);
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    cols.add(set);
                }

                int boxId = getBoxId(i, j);
                if (boxes.size() > boxId && boxes.get(boxId) != null) {
                    boxes.get(boxId).add(board[i][j]);
                } else {
                    Set<Character> set = new HashSet<>();
                    set.add(board[i][j]);
                    boxes.add(set);
                }
            }
        }

        this.sudoku(board, boxes, rows, cols, 0, 0);
    }

    private boolean sudoku(char[][] board, List<Set<Character>> boxes, List<Set<Character>> rows, List<Set<Character>> cols, int col, int row) {
        if (board[row][col] == '.') {
            for (int n = 0; n < board.length; n++) {
                if (this.isValid(board, boxes, rows, cols, row, col, values[n])) {
                    board[row][col] = values[n];
                    boxes.get(this.getBoxId(row, col)).add(values[n]);
                    rows.get(row).add(values[n]);
                    cols.get(col).add(values[n]);

                    if (col == board.length -1) {
                        if (sudoku(board,boxes,rows,cols,row+1, 0)) {
                            return true;
                        }
                    } else {
                        if (sudoku(board,boxes,rows,cols,row, col+1)) {
                            return true;
                        }
                    }
                }

                board[row][col] = '.';
                boxes.get(this.getBoxId(row, col)).remove(values[n]);
                rows.get(row).remove(values[n]);
                cols.get(col).remove(values[n]);
            }
        } else {
            if (col == board.length -1) {
                if (sudoku(board,boxes,rows,cols,row+1, 0)) {
                    return true;
                }
            } else {
                if (sudoku(board,boxes,rows,cols,row, col+1)) {
                    return true;
                }
            }
        }

        return  false;
    }

    private boolean isValid(char[][] board, List<Set<Character>> boxes, List<Set<Character>> rows, List<Set<Character>> cols, int col, int row, char value) {
        int boxId = this.getBoxId(row, col);
        if (boxes.get(boxId).contains(value) || rows.get(row).contains(value) || cols.get(col).contains(value)) {
            return false;
        }
        return true;
    }

    private int getBoxId(int i, int j) {
        int rows = Math.floorDiv(i, 3);
        int cols = Math.floorDiv(j, 3) * 3;
        return rows + cols;
    }
}