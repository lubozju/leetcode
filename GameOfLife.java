/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

// 00 - the first 0 represents the next state and the last 0 represent the old state

public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int numLiveNei = calLiveNei(board, i, j);
                if (board[i][j] == 0 && numLiveNei == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && numLiveNei >= 2 && numLiveNei <= 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] / 2;
            }
        }
    }
    
    private int calLiveNei(int[][] board, int i, int j) {
        int count = 0;
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (m + i >= 0 && m + i < board.length
                && n + j >= 0 && n + j < board[0].length) {
                    if (m == 0 && n == 0) {
                        continue;
                    }
                    count += board[m + i][n + j] % 2;
                }
            }
        }
        return count;
    }
}