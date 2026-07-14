import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            ans.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return ans;
    }
} 