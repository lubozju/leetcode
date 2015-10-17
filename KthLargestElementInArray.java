/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            swap(nums, mid, right);
            
            int lessThan = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < nums[right]) {
                    swap(nums, i, lessThan);
                    lessThan++;
                }
            }
            swap(nums, right, lessThan);
            
            if(lessThan == index) {
                return nums[lessThan];
            }
            if (lessThan > index) {
                right = lessThan - 1;
            } else {
                left = lessThan + 1;
            }
        }
        
        return nums[left];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}