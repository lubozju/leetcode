/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

*/

public class Solution {
    // bottom to top, right to left
    public int calculateMinimumHP(int[][] dungeon) {
        int sizeX = dungeon.length;
        int sizeY = dungeon[0].length;
        int[][] dp = new int[sizeX][sizeY];
        dp[sizeX - 1][sizeY - 1] = Math.max(1 - dungeon[sizeX - 1][sizeY - 1], 1);
        
        for (int i = sizeX - 1; i >= 0; i--) {
            for (int j = sizeY - 1; j >= 0; j--) {
                if (i == sizeX - 1 && j == sizeY - 1) {
                    continue;
                }
                if (i + 1 <= sizeX - 1 && j + 1 <= sizeY - 1) {
                    dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 1);
                } else if (i + 1 <= sizeX - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                }
            }
        }
        
        return dp[0][0];

    }
}

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                int min;
                if (dp[i + 1][j] == 0 || dp[i][j + 1] == 0) {
                    min = Math.max(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = Math.max(Math.max(min, 1) - dungeon[i][j], 1);
            }
        }
        
        return dp[0][0];
    }
}

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }
        int[] dp = new int[dungeon.length + 1];
        
    for (int j = dungeon[0].length - 1; j >= 0; j--) {
        for (int i = dungeon.length - 1; i >= 0; i--) {
                int min;
                if (dp[i + 1] == 0 || dp[i] == 0) {
                    min = Math.max(dp[i + 1], dp[i]);
                } else {
                    min = Math.min(dp[i + 1], dp[i]);
                }
                dp[i] = Math.max(Math.max(min, 1) - dungeon[i][j], 1);
            }
        }
        
        return dp[0];
    }
}