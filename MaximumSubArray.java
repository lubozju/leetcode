/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp >= 0 ? temp + nums[i] : nums[i];
            if (result < temp) {
                result = temp;
            }
        }
        return result;
    }
}

public class Solution {
    public int maxSubArray(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }
    
    private int help(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        
        int lresult = help(nums, left, mid - 1);
        int rresult = help(nums, mid + 1, right);
        
        int sum = nums[mid];
        int max = nums[mid];
        for (int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        sum = max;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        
        return Math.max(lresult, Math.max(rresult, max));
        
    }
}