/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        String start = nums[0] + "";
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                String end = nums[i - 1] + "";
                result.add(help(start, end));
                start = nums[i] + "";
            } 
        }
        
        result.add(help(start, nums[nums.length - 1] + ""));
        return result;
    }
    
    private String help(String start, String end) {
        if (start.equals(end)) {
            return start;
        }
        
        return start + "->" + end;
    }
}