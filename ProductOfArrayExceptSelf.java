/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

O(n) space
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int[] temp = new int[nums.length - 1];
        
        temp[0] = nums[0];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i - 1] * nums[i];
        }
        
        result[result.length - 1] = temp[temp.length - 1];
        int back = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            result[i] = back * temp[i - 1];
            back *= nums[i];
        }
        
        result[0] = back;
        
        return result;
    }
}

space O(1)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int back = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = back * result[i];
            back *= nums[i];
        }
        
        return result;
    }
}