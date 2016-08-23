/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

public class Solution {
    public int getSum(int a, int b) {
        int carryOver = 0;
        int result = 0;
        int i = 1;
        while (i != 0) {
            int aTemp = a & i;
            int bTemp = b & i;
            result = result | (aTemp ^ bTemp ^ carryOver);
            if ((aTemp & bTemp) != 0 || (aTemp & carryOver) != 0 || (bTemp & carryOver) != 0) {
                carryOver = i << 1;
            } else {
                carryOver = 0;
            }
            i = i << 1;
        }
        return result;
    }
}