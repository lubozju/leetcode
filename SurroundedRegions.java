/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        updateNone0(board);
        int x = board.length;
        if (x == 0) {
            return;
        }
        int y = board[0].length;
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void updateNone0(char[][] board) {
        int x = board.length;
        if (x == 0) {
            return;
        }
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][y - 1] == 'O') {
                bfs(board, i, y - 1);
            }
        }
        for (int i = 0; i < y; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[x - 1][i] == 'O') {
                bfs(board, x - 1, i);
            }
        }
    }
    
    private void bfs(char[][] board, int i, int j) {
        board[i][j] = 'Y';
        
        Deque<int[]> queue = new LinkedList<int[]>();
        int[] cor = new int[2];
        cor[0] = i;
        cor[1] = j;
        queue.add(cor);
        
        while (!queue.isEmpty()) {
            cor = queue.poll();
            int x = cor[0];
            int y = cor[1];
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = 'Y';
                int[] tempcor = new int[2];
                tempcor[0] = x;
                tempcor[1] = y - 1;
                queue.add(tempcor);
            }
            if (y + 1 < board[x].length && board[x][y + 1] == 'O') { 
                board[x][y + 1] = 'Y';
                int[] tempcor = new int[2];
                tempcor[0] = x;
                tempcor[1] = y + 1;
                queue.add(tempcor);
            }
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = 'Y';
                int[] tempcor = new int[2];
                tempcor[0] = x - 1;
                tempcor[1] = y;
                queue.add(tempcor); 
            }
                    
            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                board[x + 1][y] = 'Y';
                int[] tempcor = new int[2];
                tempcor[0] = x + 1;
                tempcor[1] = y;
                queue.add(tempcor); 
            }
        }
    }
}