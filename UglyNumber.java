/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/

public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 == 0) {
            boolean result = isUgly(num / 2);
            if (result == true) {
                return result;
            }
        }
        if (num % 3 == 0) {
            boolean result = isUgly(num / 3);
            if (result == true) {
                return result;
            }
        }
        if (num % 5 == 0) {
            boolean result = isUgly(num / 5);
            if (result == true) {
                return result;
            }
        }
        return false;
    }
}

public class Solution {
    // Time O(log2(n))
    // Space O(1)
    public boolean isUgly(int num) {
        // check num < 1
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}