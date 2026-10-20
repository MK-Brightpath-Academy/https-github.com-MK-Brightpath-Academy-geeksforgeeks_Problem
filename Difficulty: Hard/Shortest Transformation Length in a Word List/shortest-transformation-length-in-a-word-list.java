
import java.util.*;

class Solution {
    public int wordLadder(String[] words, String s, String e) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        if (!wordSet.contains(e)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        Set<String> visited = new HashSet<>();
        visited.add(s);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(e)) {
                    return length;
                }

                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;
                        String next = new String(chars);

                        if (wordSet.contains(next)
                                && visited.add(next)) {
                            queue.offer(next);
                        }
                    }

                    chars[j] = original;
                }
            }

            length++;
        }

        return 0;
    }
}
