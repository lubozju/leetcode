/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums2) {
            if (set.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        
        Iterator<Integer> iterator = set2.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next();
        }
        return result;
    }
}