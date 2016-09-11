/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

public class Solution {
	// O(n)
	// O(1)
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                int length = end - start + 1;
                if (length < min) {
                    min = length;
                }
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

public class Solution {
	// time O(nlogn)
	// space O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] += nums[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] >= s) {
                int index = findLess(sum, sum[i] - s);
                if (min > i - index) {
                    min = i - index;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    private int findLess(int[] sum, int target) {
        if (target < sum[0]) {
            return -1;
        }
        int left = 0;
        int right = sum.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}