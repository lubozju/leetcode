/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x0 = Math.max(A, E);
        int x1 = Math.min(C, G);
        
        int x = 0;
        if (x1 > x0) {
            x = x1 - x0;
        }

        int y0 = Math.max(B, F);
        int y1 = Math.min(D, H);
        
        int y = 0;
        if (y1 > y0) {
            y = y1 - y0;
        }
        
        int common = y * x;
        
        return (C - A) * (D - B) + (G - E) * (H - F) - common;
    }
}