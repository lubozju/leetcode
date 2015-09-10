/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

public class Solution {
    public int addDigits(int num) {
        if (num <= 9) {
            return num;
        }
        
        return addDigits(num % 10 + addDigits(num / 10));
    }
}

public class Solution {
    public int addDigits(int num) {
        while(num > 9) {
            int temp = num;
            num = 0;
            while(temp > 0) {
                num += temp % 10;
                temp = temp / 10;
            }
        }
        
        return num;
    }
}


O(1)
public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return num;
        }
        int res = num % 9;
        return (res == 0)? 9: res;
    }
}
