/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Show Company Tags
Show Tags
Show Similar Problems

*/

public class Solution {
	//Time O(m * n)
	 
    public void wallsAndGates(int[][] rooms) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Node(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = -1; k <= 1; k += 2) {
                if (validNei(node.x + k, node.y, rooms)) {
                    queue.add(new Node(node.x + k, node.y));
                    rooms[node.x + k][node.y] = rooms[node.x][node.y] + 1;
                }
                if (validNei(node.x, node.y + k, rooms)) {
                    queue.add(new Node(node.x, node.y + k));
                    rooms[node.x][node.y + k] = rooms[node.x][node.y] + 1;
                }
            }
        }
    }
    
    private boolean validNei(int x, int y, int[][] rooms) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) {
            return false;
        }
        return rooms[x][y] == Integer.MAX_VALUE;
    }
    
    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}