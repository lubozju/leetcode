/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
	// Time: O(n)
	// Space: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int numTemp = num + 1;
                while (set.contains(numTemp)) {
                    numTemp++;
                }
                result = Math.max(result, numTemp - num);
            }
        }
        return result;
    }
}