/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int[] temp = Arrays.copyOf(nums, nums.length);
        
        int index = 0;
        
        int mid = (nums.length - 1) / 2;
        
        // a[mid] < a[a.length - 1] > a[mid - 1] < a[a.length - 2] ...
        for (int i = 0; i <= mid; i++) {
            nums[index] = temp[mid - i];
            if (index + 1 < nums.length) {
                nums[index + 1] = temp[nums.length - i - 1];
            }
            index += 2;
        }
    }
}
