/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int[] result = new int[n + 1];
        
        for (int i = 1; i * i <= n; i++) {
            result[i * i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            if (result[i] == 1) {
                continue;
            }
            result[i] = n;
            for (int j = 1; j * j < i; j++) {
                int temp = result[i - j * j] + 1;
                if (temp < result[i]) {
                    result[i] = temp;
                }
            }
        }

        return result[n];
    }
}

public class Solution {
    public int numSquares(int n) {
        Deque<Integer> queue = new LinkedList<Integer>();
        
        Set<Integer> visited = new HashSet<Integer>();
        int level = 1;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Integer num = queue.poll();
                for (int i = 1; i * i <= num; i++) {
                    if (i * i == num) {
                        return level;
                    }
                    if (visited.add(num - i * i)) {
                        queue.add(num - i * i);
                    }
                }
            }
            level++;
        }
        return n;
    }
}