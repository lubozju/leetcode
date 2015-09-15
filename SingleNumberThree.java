/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/


public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        
        Integer[] temp = set.toArray(new Integer[0]);
        int[] result = {temp[0], temp[1]};
        
        return result;
    }
}

O(1) space
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for (int num : nums) {
            xor ^= num;
        }
        
        xor &= ~(xor - 1);
        
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for (int num : nums) {
            if ((num & xor) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}