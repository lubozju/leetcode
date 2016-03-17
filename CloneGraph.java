/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        return dfs(node, map);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode curNode = new UndirectedGraphNode(node.label);
        map.put(node.label, curNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            curNode.neighbors.add(dfs(neighbor, map));
        }
        
        return curNode;
    }
}

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        Deque<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node.label, result);
        
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode orgNode = queue.poll();
            UndirectedGraphNode curNode = map.get(orgNode.label);
            for (UndirectedGraphNode neighbor : orgNode.neighbors) {
                if (map.containsKey(neighbor.label)) {
                    curNode.neighbors.add(map.get(neighbor.label));
                } else {
                    UndirectedGraphNode child = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, child);
                    curNode.neighbors.add(child);
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
}