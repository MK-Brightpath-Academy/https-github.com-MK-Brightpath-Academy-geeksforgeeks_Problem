import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited))
                    return true;
            }
        }

        return false;
    }

    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            for (int neighbor : adj.get(curr.node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair(neighbor, curr.node));
                } else if (neighbor != curr.parent) {
                    return true;
                }
            }
        }

        return false;
    }
}