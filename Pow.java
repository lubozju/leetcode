/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        boolean neg = false;
        if (n < 0) {
            n = -n;
            neg = true;
        }
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            if (neg) {
                return 1 / (temp * temp);
            }
            return temp * temp;
        } 
        if (neg) {
            return 1 / (temp * temp * x);
        }
        return temp * temp * x;
    }
}

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        long nLong = n;
        if (nLong < 0) {
            nLong = -nLong;
            x = 1 / x;
        }
        
        double result = 1;
        while (nLong > 0) {
            if ((nLong & 1) == 1) {
                result *= x;
            }
            x *= x;
            nLong >>= 1;
        }
        return result;
    }
}