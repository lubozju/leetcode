/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

public class Solution {
    // Time O(n)
    // Space O(n^2)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];
            inDegree[child]++;
            List<Integer> children = map.get(parent);
            if (children == null) {
                children = new ArrayList<Integer>();
                map.put(parent, children);
            }
            children.add(child);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        
        int[] result = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            result[i++] = num;
            List<Integer> children = map.get(num);
            // children could be null
            if (children != null) {
                for (Integer child : map.get(num)) {
                    inDegree[child]--;
                // the common child will be added to the queue only once
                    if (inDegree[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        // if i < numCourses, means cannot find node with zero degree, loop
        if (i < numCourses) {
            return new int[0];
        }
        return result;
    }
}