/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int insertIndex = 1;
        
        int count = 1;
        while (index < nums.length) {
            if (nums[index] != nums[index - 1]) {
                count = 1;
                nums[insertIndex] = nums[index];
                insertIndex++;
            } else {
                if (count < 2) {
                    count++;
                    nums[insertIndex] = nums[index];
                    insertIndex++;
                }
            }
            index++;
        }
        return insertIndex;
    }
}

public class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 0;
        
        for (int num : nums) {
            if (insertIndex < 2 || num > nums[insertIndex - 2]) {
                nums[insertIndex] = num;
                insertIndex++;
            }
        }
        return insertIndex;
    }
}