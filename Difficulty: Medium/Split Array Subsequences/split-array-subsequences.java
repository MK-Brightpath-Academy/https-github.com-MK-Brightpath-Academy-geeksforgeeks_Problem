
import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Process each element
        for (int num : arr) {

            // Already used
            if (freq.get(num) == 0) {
                continue;
            }

            // Step 3: Extend existing subsequence
            if (end.getOrDefault(num - 1, 0) > 0) {

                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);

                freq.put(num, freq.get(num) - 1);

            } else {

                // Step 4: Start new subsequence
                for (int i = 0; i < k; i++) {

                    int next = num + i;

                    if (freq.getOrDefault(next, 0) == 0) {
                        return false;
                    }

                    freq.put(next, freq.get(next) - 1);
                }

                end.put(num + k - 1,
                    end.getOrDefault(num + k - 1, 0) + 1);
            }
        }

        return true;
    }
}
