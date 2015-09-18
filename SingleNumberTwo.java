/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
            set.add(num);
            
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            
            // count = 4, 5, 6 ...
            if (map.get(num) > 3) {
                return num;
            } else if(map.get(num) == 3) {
                set.remove(num);
            }
        }
        
        // will only contains count = 1, 2 
        Integer[] array = set.toArray(new Integer[0]);
        
        return array[0];
    }
}