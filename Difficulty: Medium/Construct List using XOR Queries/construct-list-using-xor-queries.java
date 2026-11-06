import java.util.*;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        int xor = 0;

        // Initially array contains 0
        result.add(0);

        // Process queries
        for (int[] query : queries) {

            int type = query[0];
            int x = query[1];

            if (type == 0) {

                // Insert x after applying previous XOR
                result.add(x ^ xor);

            } else {

                // Update cumulative XOR
                xor ^= x;
            }
        }

        // Apply final XOR to all elements
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) ^ xor);
        }

        // Sort the final list
        Collections.sort(result);

        return result;
    }
}