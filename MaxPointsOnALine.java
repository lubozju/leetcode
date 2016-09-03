/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    // Time: O(n^2)
    // Space: O(n^2)
    public int maxPoints(Point[] points) {
        if (points.length == 1) {
            return 1;
        }
        int result = 0;

        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
            int verticalCount = 1; // for k = +-infinite
            int horizonCount = 1; // for k = +-0
            int samePoints = 0; // for the same point as point[i]
            int localResult = 0; // local maxium for each point[i]
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                } else if (points[i].x == points[j].x) {
                    verticalCount++; 
                    localResult = Math.max(localResult, verticalCount);
                } else if (points[i].y == points[j].y) {
                    horizonCount++;
                    localResult = Math.max(localResult, horizonCount);
                } else {
                    double k = ((double)(points[i].y - points[j].y)) / (points[i].x - points[j].x);
                    Integer count = slopeMap.get(k);
                    if (count == null) {
                        slopeMap.put(k, 2);
                    } else {
                        slopeMap.put(k, count + 1);
                    }
                    localResult = Math.max(localResult, slopeMap.get(k));
                }
            }
            if (localResult == 0) {
                localResult++;
            }
            localResult += samePoints;
            result = Math.max(localResult, result);
        }
        return result;
    }

public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int numOfSamePoints = 0;
            int localMax = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].y == points[j].y && points[i].x == points[j].x) {
                    numOfSamePoints++;
                } else {
                    Double slope = ((double)(points[i].y - points[j].y)) / (points[i].x - points[j].x);
                    if (points[i].y == points[j].y || points[i].x == points[j].x) {
                        slope = Math.abs(slope);
                    }
                    Integer count = map.get(slope);
                    if (count == null) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, count + 1);
                    }
                    localMax = Math.max(localMax, map.get(slope));
                }
            }
            max = Math.max(max, 1 + numOfSamePoints + localMax);
        }
        return max;
    }
}    