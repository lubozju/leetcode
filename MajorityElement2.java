/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (count > Math.floor(nums.length / 3)) {
                    result.add(nums[i - 1]);
                }
                count = 1;
            } else {
                count++;
            }
        }
        if (count > Math.floor(nums.length / 3)) {
            result.add(nums[nums.length - 1]);
        }
        return result;
    }
}