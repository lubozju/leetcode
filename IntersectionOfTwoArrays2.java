/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int num1 : nums1) {
            Integer count = map1.get(num1);
            if (count == null) {
                map1.put(num1, 1);
            } else {
                map1.put(num1, 1 + count);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for (int num2 : nums2) {
            Integer count = map1.get(num2);
            if (count != null) {
                list.add(num2);
                if (count == 1) {
                    map1.remove(num2);
                } else {
                    map1.put(num2, count - 1);
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<Integer>();
        
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        
        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }
        
        return result;
    }
}