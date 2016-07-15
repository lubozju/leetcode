/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/

public class Solution {
    // Time O(n)
    // Space O(1)
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        int reach = 0;
        int nextReach = 0;
        for (int i = 0; i <= reach; i++) {
            nextReach = Math.max(nums[i] + i, nextReach);
            if (nextReach >= nums.length - 1) {
                return step + 1;
            }
            if (i == reach) {
                step++;
                reach = nextReach;
            }
        }
        return Integer.MAX_VALUE;
    }
}