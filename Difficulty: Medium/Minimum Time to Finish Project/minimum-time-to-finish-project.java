import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] finishTime = new int[n];

        for (int i = 0; i < n; i++) {
            finishTime[i] = duration[i];

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

            answer = Math.max(answer, finishTime[u]);

            for (int v : adj.get(u)) {
                finishTime[v] = Math.max(
                    finishTime[v],
                    finishTime[u] + duration[v]
                );

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return processed == n ? answer : -1;
    }
}