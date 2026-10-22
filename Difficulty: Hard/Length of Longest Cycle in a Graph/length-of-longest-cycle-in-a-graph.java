
class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] next = new int[V];
        java.util.Arrays.fill(next, -1);

        for (int[] edge : edges) {
            next[edge[0]] = edge[1];
        }

        int[] visited = new int[V];
        int[] depth = new int[V];

        int longest = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i] != 0) {
                continue;
            }

            int node = i;
            int currentDepth = 0;

            while (node != -1 && visited[node] == 0) {
                visited[node] = i + 1;
                depth[node] = currentDepth++;

                node = next[node];
            }

            if (node != -1 && visited[node] == i + 1) {
                int cycleLength = currentDepth - depth[node];
                longest = Math.max(longest, cycleLength);
            }
        }

        return longest;
    }
}
