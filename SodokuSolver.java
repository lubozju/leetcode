/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.


*/

public class Solution {
    public void solveSudoku(char[][] board) {
        List<int[]> nodes = new ArrayList<int[]>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    int[] cordi = {i, j};
                    nodes.add(cordi);
                }
            } 
        }
        
        dfs(board, nodes, 0);
    }
    
    private boolean dfs(char[][] board, List<int[]> nodes, int index) {
        if (index == nodes.size()) {
            return true;
        }
        
            int[] cord = nodes.get(index);
            
            for (int i = 1; i < 10; i++) {
                if (isValid(board, cord, (char)('0' + i))) {
                    board[cord[0]][cord[1]] = (char)('0' + i);
                    if(!dfs(board, nodes, index + 1)) {
                        board[cord[0]][cord[1]] = '.';
                    } else {
                        return true;
                    }
                }
            }
            return false;
    }
    
    private boolean isValid(char[][] board, int[] cord, char c) {
        if(!checkHorizontal(board, cord[0], c)) {
            return false;
        }
        if (!checkVertical(board, cord[1], c)) {
            return false;
        }
        if (!checkSqr(board, cord, c)) {
            return false;
        }
        return true;
    }
    private boolean checkHorizontal(char[][] board, int x, char c) {
        for (int i = 0; i < board[x].length; i++) {
            if (board[x][i] == c) {
                return false;
            }
        }
        return true;
    }
    private boolean checkVertical(char[][] board, int x, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][x] == c) {
                return false;
            }
        }
        return true;
    }
    private boolean checkSqr(char[][] board, int[] cord, char c) {
        int m = cord[0] / 3;
        int n = cord[1] / 3;
        
        for (int i = 3 * m; i < 3 * m + 3; i++) {
            for (int j = 3 * n; j < 3 * n + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}