/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int left = 0; 
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] == n - mid) {
                return citations[mid];
            }
            if (citations[mid] > n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        return n - left;
    }
}