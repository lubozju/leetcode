/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // Time O(nlogn)
    // Space O(1)
    public int minMeetingRooms(Interval[] intervals) {
        End[] ends = new End[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            ends[2 * i] = new End(intervals[i].start, true);
            ends[2 * i + 1] = new End(intervals[i].end, false);
        }
        
        
        Arrays.sort(ends, new Comparator<End>() {
            @Override
            public int compare(End in1, End in2) {
                int result = in1.val - in2.val;
                if (result != 0) {
                    return result;
                }
                if (in1.isStart) {
                    return 1;
                }
                return -1;
            }
        });
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < ends.length; i++) {
            if (ends[i].isStart) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }
    
    private static class End {
        int val;
        boolean isStart;
        public End(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
    }
}