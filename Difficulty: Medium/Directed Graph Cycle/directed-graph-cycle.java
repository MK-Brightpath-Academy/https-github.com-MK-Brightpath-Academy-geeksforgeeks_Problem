import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, adj, visited, pathVisited))
                    return true;

            } else if (pathVisited[neighbor]) {

                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }
}