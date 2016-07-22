/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        
        // find the right most i such that nums[i - 1] < nums[i]
        while (i >= 1) {
            if (nums[i] <= nums[i - 1]) {
                i--;
            } else {
                break;
            }
        }
        // if the number exist, swap the first number that is bigger than it
        if (i - 1 >= 0) {
            int n = nums[i - 1];
            int j = nums.length - 1;
            while (nums[j] <= n) {
                j--;
            }
            nums[i - 1] = nums[j];
            nums[j] = n;
        }
        
        // nums[i] to nums[nums.length - 1] is descending, needs to reverse it
        reverse(nums, i, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

public class Solution {
    // Time O(n)
    // Space O(1)
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        
        while (i >= 1 && nums[i] <= nums[i - 1]){
            i--;
        }
        
        reverse(nums, i, nums.length - 1);
        if (i > 0) {
            int j = i;
            while (nums[i - 1] >= nums[j]) {
                j++;
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}