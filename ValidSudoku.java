/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && check33(board);
    }
    
    private boolean checkRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] > '9' || board[i][j] < '1' || !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkCol(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (board[j][i] > '9' || board[j][i] < '1' || !set.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check33(char[][] board) {
        for (int i = 0; i < board.length / 3; i++) {
            for (int j = 0; j < board[i].length / 3; j++) {
                Set<Character> set = new HashSet<Character>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        int x = m + i * 3;
                        int y = n + j * 3;
                        if (board[x][y] == '.') {
                            continue;
                        }
                        if (board[x][y] > '9' || board[x][y] < '1' || !set.add(board[x][y])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}