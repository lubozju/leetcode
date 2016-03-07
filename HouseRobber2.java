/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[][] result = new int[length][length];
        
        for (int i = 0; i < length; i++) {
            result[i][i] = nums[i];
        }
        
        for (int d = 1; d < length; d++) {
            for (int start = 0; start + d < length; start++) {
                int end = start + d;
                result[start][end] = 0;
                for (int i = start; i <= end; i++) {
                    int temp = 0;
                    if (start == 0 && end == length - 1) {
                        if (i - 1 >= start + 1) {
                            temp += result[start + 1][i - 1];
                        }
                        if (i + 1 <= end) {
                            temp += result[i + 1][end];
                        }
                        if (temp > result[start][end]) {
                            result[start][end] = temp;
                        }
                        temp = 0;
                        if (i - 1 >= start) {
                            temp += result[start][i - 1];
                        }
                        if (i + 1 <= end - 1) {
                            temp += result[i + 1][end - 1];
                        }
                        if (temp > result[start][end]) {
                            result[start][end] = temp;
                        }
                    } else {
                        if (i - 1 >= start) {
                            temp += result[start][i - 1];
                        }
                        if (i + 1 <= end) {
                            temp += result[i + 1][end];
                        }
                        if (temp > result[start][end]) {
                            result[start][end] = temp;
                        }
                    }
                }
            }
        }
        
        return result[0][nums.length - 1];
    }
}


public class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        return Math.max(help(nums, 0, nums.length - 2), nums[nums.length - 1] + help(nums, 1, nums.length - 3));
    }
    
    private int help(int[] nums, int s, int e) {
        int rob = 0;
        int notRob = 0;
        int result = 0;
        for (int i = s; i <= e; i++) {
            int temp = rob;
            rob = notRob + nums[i];
            notRob = Math.max(notRob, temp);
            result = Math.max(result, Math.max(rob, notRob));
        }
        return result;
    }
}