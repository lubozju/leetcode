/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, word, visited, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int curIndex, String word, boolean[][] visited, char[][] board) {
        if (curIndex == word.length() - 1) {
            return true;
        }
        
        visited[i][j] = true;
        
        for (int k = -1; k <= 1; k += 2) {
            if (i + k >= 0 && i + k < board.length && !visited[i + k][j] && board[i + k][j] == word.charAt(curIndex + 1)) {
                if (dfs(i + k, j, curIndex + 1, word, visited, board)) {
                    return true;
                }
            }
            if (j + k >= 0 && j + k < board[i].length && !visited[i][k + j] && board[i][j + k] == word.charAt(curIndex + 1)) {
                if (dfs(i, j + k, curIndex + 1, word, visited, board)) {
                    return true;
                }
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}