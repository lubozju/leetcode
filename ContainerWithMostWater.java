/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int result = 0;
        
        while (left < right) {
            int size;
            if (height[left] < height[right]) {
                size = height[left] * (right - left);
                left++;
            } else {
                size = height[right] * (right - left);
                right--;
            }
            if (size > result) {
                result = size;
            }
        }
        return result;
    }
}

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int result = 0;
        int h;
        while (left < right) {
            int size;
            h = Math.min(height[left], height[right]);
            size = h * (right - left);
            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
            if (size > result) {
                result = size;
            }
        }
        return result;
    }
}