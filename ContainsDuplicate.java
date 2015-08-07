/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        
        return false;
    }
}


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        
        return false;
    }
}