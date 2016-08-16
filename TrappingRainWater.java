/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    // Time: O(n)
    // Space: O(n)
    public int trap(int[] height) {
        int result = 0;
        int minus = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if (height[i] < height[stack.peek()]) {
                        stack.push(i);
                    } else {
                        int index = 0;
                        while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                            index = stack.pop();
                            minus += height[index];
                        }
                        if (stack.isEmpty()) {
                            result += height[index] * (i - index - 1) - minus + height[index];
                            minus = 0;
                        }
                        stack.push(i);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!stack.isEmpty()) {
                result += height[index] * (index - stack.peek() - 1);
            }
        }
        return result - minus;
    }
}

public class Solution {
    // Time O(n)
    // Space O(n)
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int toBeSub = 0;
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.empty() && height[i] >= height[stack.peek()]) {
                int index = stack.pop();
                int water = height[index] * (i - index - 1);
                total += water;
                if (!stack.empty()) {
                    toBeSub += height[index];
                    // toBeSub is the removed height and the water bounded by that height
                    toBeSub += water;
                }
            }
            stack.push(i);
        }
        int index = stack.pop();
        while (!stack.empty()) {
            total += height[index] * (index - stack.peek() - 1);
            index = stack.pop();
        }
        total -= toBeSub;
        
        return total;
    }
}


    // Time O(n)
    // Space O(1)
    public int trap(int[] height) {
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
            
            if (maxLeft <= maxRight) {
                total += maxLeft - height[left];
                left++;
            } else {
                total += maxRight - height[right];
                right--;
            }
        }
        return total;
    }