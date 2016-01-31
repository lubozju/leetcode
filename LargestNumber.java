/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o2 + o1;
                String s2 = "" + o1 + o2;
                return s1.compareTo(s2);
            }
        });
        
        if(sorted[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        
        for (Integer num : sorted) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}