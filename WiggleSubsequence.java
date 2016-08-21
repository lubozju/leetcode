A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?

public class Solution {
    // Time O(n^2)
    // Space O(n)
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] posDp = new int[nums.length];
        int[] negDp = new int[nums.length];
        
        posDp[0] = 1;
        negDp[0] = 1;
        
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            posDp[i] = 1;
            negDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    posDp[i] = Math.max(posDp[i], negDp[j] + 1);
                } else if (nums[i] < nums[j]) {
                    negDp[i] = Math.max(negDp[i], posDp[j] + 1);
                }
            }
            max = Math.max(max, Math.max(posDp[i], negDp[i]));
        }
        
        return max;
    }
}

public class Solution {
    // Time O(n)
    // Space O(1)
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Boolean incl = null;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((incl == null || incl) && nums[i] < prev) {
                incl = false;
                count++;
            } else if ((incl == null || !incl) && nums[i] > prev) {
                incl = true;
                count++;
            }
            prev = nums[i];
        }
        return count;
    }
}

public class Solution {
    // Time O(n)
    // Space O(1)
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int neg = 1; // the largest neg found so far
        int pos = 1; // the largest pos found so far
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pos = neg + 1;
            } else if (nums[i] < nums[i - 1]) {
                neg = pos + 1;
            }
        }
        
        return Math.max(neg, pos);
    }
}