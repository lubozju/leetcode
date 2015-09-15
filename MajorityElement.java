/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

Time: O(n)
Space: O(n)
public class Solution {
    public int majorityElement(int[] nums){
        if (nums == null) {
            return 0;
        }
        
        int half = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.put(num, 1 + count.get(num));
            }
            
            if (count.get(num) > half) {
                return num;
            }
        }
        
        return nums[0];
    }
}

Time: O(nlogn)
Space: O(n)
public class Solution {
    public int majorityElement(int[] nums){
        if (nums == null) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int mid = nums.length / 2;
        return nums[mid];
    }
}

O(n)
public class Solution {
    public int majorityElement(int[] nums){
        if (nums == null) {
            return 0;
        }
        
        int mid = nums.length / 2;
               
        return quickSelect(nums, mid);
    }
    
    private int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            
            int index = partition(nums, left, right, pivot);
            
            if (index == k) {
                return nums[index];
            }
            
            if (index > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        
        return nums[left];
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    private int partition(int[] nums, int left, int right, int pivot) {
        swap(nums, pivot, right);
        // result is the first index that is >= nums[pivot]
        int result = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, result);
                result++;
            }
        }
        
        swap(nums, result, right);
        
        return result;
    }
}