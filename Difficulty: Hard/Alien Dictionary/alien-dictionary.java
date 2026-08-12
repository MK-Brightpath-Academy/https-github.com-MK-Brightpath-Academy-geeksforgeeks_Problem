class Solution {

    public String findOrder(String[] words) {

        // Graph for 26 lowercase English letters
        boolean[][] graph = new boolean[26][26];

        // Indegree of every character
        int[] indegree = new int[26];

        // Find all characters actually present
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            boolean found = false;

            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    int u = c1 - 'a';
                    int v = c2 - 'a';

                    // Avoid duplicate edge
                    if (!graph[u][v]) {
                        graph[u][v] = true;
                        indegree[v]++;
                    }

                    found = true;
                    break;
                }
            }

            // Invalid case:
            // "abc" comes before "ab"
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        // Topological Sort (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            int u = queue.poll();

            result.append((char) (u + 'a'));

            for (int v = 0; v < 26; v++) {

                if (graph[u][v]) {

                    indegree[v]--;

                    if (indegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
        }

        // Cycle detected
        int totalCharacters = 0;

        for (boolean p : present) {
            if (p) {
                totalCharacters++;
            }
        }

        if (result.length() != totalCharacters) {
            return "";
        }

        return result.toString();
    }
}