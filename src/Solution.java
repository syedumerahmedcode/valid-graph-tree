
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


public class Solution {

    public boolean validTree(int n, int[][] edges) {
        /**
         * In order to check if the given graph is a valid tree, we have to check two things:
         * 1) There is no cycle among the nodes/vertices
         * 2) All verzices/nodes are connected
         */
        /**
         * If the difference between nodes and edges is not 1[nodes  have a 1 more value then edges],
                 * then this is not a valid tree and we return false immediately
         */
        if (edges.length != n - 1) {
            return false;
        }
        /**
         * We create an adjacency List to check through
         */
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // here n is treated as vertices
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            /**
             * We have to add two entries to create an undirected graph, as in, 
             * if(0--1),
                     * then (0--->1) and (1--->0)
             */
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        /**
         * Doing iterative dfs
         */
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (visited.contains(neighbour)) {
                    // do nothing
                    continue;
                }
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }
        if (visited.size() == n) {
            return true;
        }
        return false;

        
    }

}
