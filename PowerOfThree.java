/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/


public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}

public class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("10*");
    }
}