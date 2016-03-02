/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        
        int pos = nums[0];
        int nPos = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempPos;
            tempPos = Math.max(Math.max(pos * nums[i], nPos * nums[i]), nums[i]);

            if (tempPos > result) {
                result = tempPos;
            }
            
            nPos = Math.min(Math.min(pos * nums[i], nPos * nums[i]), nums[i]);
            pos = tempPos;
        }
        return result;
    }
}