/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num <= 1) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}