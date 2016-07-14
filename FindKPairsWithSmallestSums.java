/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/

public class Solution {
    // Time O(m * m * log(k))
    // Space (k)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (minHeap.size() == k) {
                    Pair pair = minHeap.peek();
                    if (pair.num1 + pair.num2 > nums1[i] + nums2[j]) {
                        minHeap.poll();
                        minHeap.add(new Pair(nums1[i], nums2[j]));
                    }
                } else {
                    minHeap.add(new Pair(nums1[i], nums2[j]));
                }
            }
        }
        while (minHeap.size() > 0) {
            Pair pair = minHeap.poll();
            int[] temp = new int[2];
            temp[0] = pair.num1;
            temp[1] = pair.num2;
            result.add(temp);
        }
        return result;
    }
    
    private static class Pair implements Comparable<Pair>{
        private int num1;
        private int num2;
        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
        public int compareTo(Pair o) {
            return (o.num1 + o.num2) - (num1 + num2);
        }
    }
}

public class Solution {
    // Time O(k * log(k))
    // Space (k)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        
        for (int i = 0; i < k && i < nums1.length; i++) {
            minHeap.add(new Pair(nums1[i], nums2[0], i, 0));
        }
        
        while (k > 0 && minHeap.size() > 0) {
            Pair pair = minHeap.poll();
            int[] temp = new int[2];
            temp[0] = pair.num1;
            temp[1] = pair.num2;
            result.add(temp);
            int index1 = pair.index1;
            int index2 = pair.index2;
            
            if (index2 + 1 < nums2.length) {
                minHeap.add(new Pair(nums1[index1], nums2[index2 + 1], index1, index2 + 1));
            }
            k--;
        }
        return result;
    }
    
    private static class Pair implements Comparable<Pair>{
        private int num1;
        private int num2;
        private int index1;
        private int index2;
        public Pair(int num1, int num2, int index1, int index2) {
            this.num1 = num1;
            this.num2 = num2;
            this.index1 = index1;
            this.index2 = index2;
        }
        public int compareTo(Pair o) {
            return (num1 + num2) - (o.num1 + o.num2);
        }
    }
}