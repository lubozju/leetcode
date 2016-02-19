/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(0, 0, board);
    }
    
    private boolean dfs(int x, int y, char[][] board) {
        if (x == board.length) {
            return true;
        }
        if (board[x][y] != '.') {
            if (y + 1 < board[0].length) {
                return dfs(x, y + 1, board);
            }
            return dfs(x + 1, 0, board);
        }
        
        for (int i = 1; i <= 9; i++) {
            if (isValid((char)(i + '0'), x, y, board)) {
                board[x][y] = (char)(i + '0');
                if (y + 1 < board[0].length) {
                    if (dfs(x, y + 1, board)) {
                        return true;
                    }
                } else {
                    if (dfs(x + 1, 0, board)) {
                        return true;
                    }
                }
                board[x][y] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char number, int x, int y, char[][] board) {
        return checkRow(board, x, number) && checkCol(board, y, number) && check33(board, x / 3, y / 3, number);
    }
    
    private boolean checkRow(char[][] board, int x, char number) {
        for (int i = 0; i < board[x].length; i++) {
            if (board[x][i] == number) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int y, char number) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == number) {
                return false;
            }
        }
        return true;
    }
    
    private boolean check33(char[][] board, int x, int y, char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[3 * x + i][3 * y + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}