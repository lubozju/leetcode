/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null) {
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(i, j, grid);
                }
            }
        }
        return result;
    }
    private static class Node {
        int x;
        int y;
        
        private Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private int getX() {
            return x;
        }
        private int getY() {
            return y;
        }
    }
    
    private void bfs(int i, int j, char[][] grid) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(i, j));
        grid[i][j] = '0';// should assign '0' before enqueu to reduce duplication
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int k = -1; k <= 1; k += 2) {
                if (x + k >= 0 && x + k < grid.length && grid[x + k][y] == '1') {
                    queue.add(new Node(x + k, y));
                    grid[x + k][y] = '0';
                }
                if (y + k >= 0 && y + k < grid[0].length && grid[x][y + k] == '1') {
                    queue.add(new Node(x, y + k));
                    grid[x][y + k] = '0';
                }
            }
        }
    }
}