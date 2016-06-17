/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.*/

public class Solution {
    // Time: O(nlogn)
    // Space: O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

public class Solution {
    // Time: O(nlogk)
    // Space: O(1)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                if(heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }
}

public class Solution {
    // Time: O(n)
    // Space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = rearrange(nums, mid, left, right);
            if (index == nums.length - k) {
                return nums[index];
            }
            if (index < nums.length - k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[left];
    }
    
    private int rearrange(int[] nums, int pivot, int left, int right) {
        swap(nums, pivot, right);
        int indexLE = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                swap(nums, indexLE++, i);
            }
        }
        swap(nums, indexLE, right);
        return indexLE;
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}