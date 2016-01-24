/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> bst = new TreeSet<Long>();
        
        for (int i = 0; i < nums.length; i++) {
            Long floor = bst.floor(((long) nums[i]) + t);
            if (floor != null && floor >= ((long) nums[i]) - t) {
                return true;
            }
            
            bst.add((long) nums[i]);
            if (i >= k) {
                bst.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // if nums[i] is negtive, {-3 ... 3} / 4 will be 0 which too big for the bucket
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<Long, Long>();
        
        for (int i = 0; i < nums.length; i++) {
            long mapNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = mapNum / ((long)t + 1);
            
            if (map.containsKey(bucket) || map.containsKey(bucket - 1) && mapNum - map.get(bucket - 1) <= t
            || map.containsKey(bucket + 1) && map.get(bucket + 1) - mapNum <= t) {
                return true;
            }
            
            if (i >= k) {
                map.remove(((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1));
            }
            map.put(bucket, mapNum);

        }
        return false;
    }
}