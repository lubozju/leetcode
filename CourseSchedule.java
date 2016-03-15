/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        for (int i = 0; i < numCourses; i++) {
            Node n = new Node();
            n.setVal(i);
            map.put(i, n);
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            
            Node startNode = map.get(start);
            if (startNode == null) {
                startNode = new Node();
                startNode.setVal(start);
                map.put(start, startNode);
            }

            List<Node> neighbors = startNode.getNeighbors();
            if (neighbors == null) {
                neighbors = new ArrayList<Node>();
                startNode.setNeighbors(neighbors);
            }
            Node endNode = map.get(end);
            if (endNode == null) {
                endNode = new Node();
                endNode.setVal(end);
                map.put(end, endNode);
            }
            neighbors.add(endNode);
        }
        
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited, map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int index, boolean[] visited, Map<Integer, Node> map) {
        Node node = map.get(index);
        if (visited[index]) {
            return node.getFinish();
        }
        
        visited[index] = true;
        List<Node> nei = node.getNeighbors();
        if (nei != null) {
            for (Node n : nei) {
                if(!dfs(n.getVal(), visited, map)) {
                    return false;
                }
            }
        }
        node.setFinish(true);
        return true;
    }
    
    private static class Node {
        private int val;
        private boolean finish;
        private List<Node> neighbors;
        
        private boolean getFinish() {
            return finish;
        }
        
        private void setFinish(boolean finish) {
            this.finish = finish;
        }
        private List<Node> getNeighbors() {
            return neighbors;
        }
        private void setNeighbors(List<Node> neighbors) {
            this.neighbors = neighbors;
        }
        private void setVal(int val) {
            this.val = val;
        }
        private int getVal() {
            return val;
        }
    }
}


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = getGraph(prerequisites);
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                Set<Integer> localVisited = new HashSet<Integer>();
                if (!dfs(i, graph, visited, localVisited)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> localVisited) {
        if (localVisited.contains(i)) {
            return false;
        }
        if (visited.contains(i)) {
            return true;
        }
        
        localVisited.add(i);
        visited.add(i);
        List<Integer> tos = graph.get(i);
        if (tos != null) {
            for (int n : tos) {
                if (!dfs(n, graph, visited, localVisited)) {
                    return false;
                }
            }
        }
        localVisited.remove(i);

        return true;
    }
    
    private Map<Integer, List<Integer>> getGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            
            List<Integer> tos = map.get(from);
            if (tos == null) {
                tos = new ArrayList<Integer>();
                map.put(from, tos);
            }
            tos.add(to);
        }
        
        return map;
    }
}