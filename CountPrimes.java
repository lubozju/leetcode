/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0; 
        }
        boolean[] sieves = new boolean[n];
        
        for (int i = 3; i < n; i += 2) {
            if (sieves[i]) {
                continue;
            }
            int p = i;
            for (int j = 3 * p ; j < n; j += 2 * p) {
                sieves[j] = true;
            }
        }
        
        int result = 1;
        
        for (int i = 3; i < n; i += 2) {
            result += !sieves[i] ? 1 : 0; 
        }
        
        return result;
    }
}