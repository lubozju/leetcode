/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k 
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i = 0;i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        
        if (!queue.isEmpty()) {
            result[0] = queue.peekFirst();
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            result[i - k + 1] = queue.peekFirst();
        }
        return result;
    }
}