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
        // make everthing 0 based
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        int facto = 1;
        for (int i = 2; i < n; i++) {
            facto *= i;
        }
        
        for (int i = 0; i < n - 1; i++) {
            int index = k / facto;
            k = k % facto;
            facto /= (n - 1 - i);
            
            int number = find(used, index);
            sb.append(number);
        }
        
        int number = find(used, 0);
        sb.append(number);
    
        return sb.toString();
    }
    
    // find the indexth unused number (0 based) from (1 - n)
    private int find(boolean[] used, int index) {
        int count = -1;
        int i = 0;
        while (count != index) {
            if (used[i] == false) {
                count++;
            }
            i++;
        }
        used[i - 1] = true;
        return i;
    }
}