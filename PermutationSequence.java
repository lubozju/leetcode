/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.


*/

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        boolean[] used = new boolean[n];

        k = k - 1;
        while (n > 0) {
            factorial /= n;
            int index = k / factorial;
            sb.append(find(used, index));
            k = k % factorial;
            n--;
        }
        
        return sb.toString();
    }
    
    private int find (boolean[] used, int index) {
        int count = -1;
        int i = 0;
        while (count < index) {
            if (!used[i]) {
                count++;
            }
            i++;
        }
        used[i - 1] = true;
        return i;
    }
}