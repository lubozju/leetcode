/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int min = nums.length + 1;
        
        int sum = 0;
        
        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            // end - 1 is the actual end and "end - 1" is the smallest end that starts at "start" 
            
            if (sum < s) {
                break;   
            }
            while (sum >= s) {
                sum -= nums[start];
                start++;
            }
            // start - 1 is the actual start and "start - 1" is the largest start that end at "end - 1"
            if (min > end - start + 1) {
                min = end - start + 1;
            }
        }
        
        if (min == nums.length + 1) {
            return 0;
        }
        return min;
    }
}

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        int min = nums.length + 1;
        
        for (int start = 0; start < nums.length; start++) {
            // find sum[end] >= sum[start] + s in which end is the smallest
            // end = {start + 1, nums.length}
            int end = bs(start + 1, nums.length, sum[start] + s, sum);
            
            // when cannot find
            if (end == nums.length + 1) {
                break;
            }
            // start ... end - 1 is the actual subarray
            if (min > end - start) {
                min = end - start;
            }
        }
        
        if (min == nums.length + 1) {
            return 0;
        }
        return min;
    }
    
    // sum[left - 1] < key sum[right + 1] >= key
    private int bs(int left, int right, int key, int[] sum) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}