
class Solution {
    public ArrayList<ArrayList<String>> findSequences(
            String[] words, String s, String e) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));

        if (!wordSet.contains(e)) {
            return result;
        }

        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(s);
        queue.offer(startPath);

        HashSet<String> visited = new HashSet<>();
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            HashSet<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {
                ArrayList<String> path = queue.poll();
                String word = path.get(path.size() - 1);

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[i] = c;
                        String next = new String(chars);

                        if (!wordSet.contains(next)) continue;
                        if (visited.contains(next)) continue;

                        ArrayList<String> newPath =
                                new ArrayList<>(path);
                        newPath.add(next);

                        if (next.equals(e)) {
                            result.add(newPath);
                            found = true;
                        } else {
                            queue.offer(newPath);
                            levelVisited.add(next);
                        }
                    }

                    chars[i] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        return result;
    }
}
