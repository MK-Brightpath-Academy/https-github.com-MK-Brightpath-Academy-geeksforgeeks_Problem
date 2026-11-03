
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<String> findPrefixes(String[] arr) {

        ArrayList<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Step 1: Build Trie
        for (String word : arr) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];

                // Count words passing through this node
                current.count++;
            }
        }

        // Step 2: Find shortest unique prefix
        for (String word : arr) {

            TrieNode current = root;
            StringBuilder prefix = new StringBuilder();

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                current = current.children[index];
                prefix.append(ch);

                // Only one word has this prefix
                if (current.count == 1) {
                    break;
                }
            }

            result.add(prefix.toString());
        }

        return result;
    }
}
