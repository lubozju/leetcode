/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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
    // Time O(1)
    public List<Interval> merge(List<Interval> intervals) {
        
    Collections.sort(intervals, new Comparator() {
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Interval && o2 instanceof Interval) {
                Interval s_1 = (Interval)o1;
                Interval s_2 = (Interval)o2;
                return s_1.start - s_2.start;
            } 
            return 0;    
        }
    });
    
    Iterator<Interval> iterator = intervals.iterator();
    Interval prev = null;
    while (iterator.hasNext()) {
        Interval cur = iterator.next();
        if (prev != null) {
            if (cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
                iterator.remove();
            } else {
                prev = cur;
            }
        } else {
            prev = cur;  
        }
    }
        return intervals;
    }
}

public class Solution {
    // Time O(nlogn)
    // Time O(n)
    public List<Interval> merge(List<Interval> intervals) {
        
    Collections.sort(intervals, new Comparator() {
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Interval && o2 instanceof Interval) {
                Interval s_1 = (Interval)o1;
                Interval s_2 = (Interval)o2;
                return s_1.start - s_2.start;
            } 
            return 0;    
        }
    });
    
    List<Interval> result = new ArrayList<Interval>();
    Interval cur = null;
    for (Interval interval : intervals) {
        if (cur != null) {
            if (cur.end >= interval.start) {
                cur.end = Math.max(cur.end, interval.end);
            } else {
                result.add(cur);
                cur = interval;
            }
        } else {
            cur = interval;
        }
    }
    if (cur != null) {
        result.add(cur); 
    }

    return result;
    }
}