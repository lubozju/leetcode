/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        
        int left = 1;
        int right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if ((mid + 1) <= x / (mid + 1)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
        
    }

    public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return bst(0, x, x);
    }
    // x * x <= sqrt (x + 1) * (x + 1) > sqrt
    private int bst(int min, int max, int target) {
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            if (target / mid < mid) {
                max = mid;
            } else if (target / mid >= mid) {
                min = mid;
            }
        }
        return min;
    }
}