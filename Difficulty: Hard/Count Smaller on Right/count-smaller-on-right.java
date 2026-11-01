
import java.util.*;

class Solution {

    public int[] lowerArray(int[] arr) {

        int n = arr.length;

        // Step 1: Coordinate Compression
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Remove duplicates
        int size = 0;

        for (int x : sorted) {
            if (size == 0 || sorted[size - 1] != x) {
                sorted[size++] = x;
            }
        }

        // Step 2: Fenwick Tree
        int[] bit = new int[size + 1];
        int[] ans = new int[n];

        // Step 3: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Find compressed rank (1-based)
            int rank = Arrays.binarySearch(
                sorted, 0, size, arr[i]
            ) + 1;

            // Count smaller elements on right
            ans[i] = query(bit, rank - 1);

            // Insert current element
            update(bit, rank);
        }

        return ans;
    }

    // Fenwick Tree Update
    private void update(int[] bit, int index) {

        while (index < bit.length) {
            bit[index]++;
            index += index & -index;
        }
    }

    // Fenwick Tree Query
    private int query(int[] bit, int index) {

        int count = 0;

        while (index > 0) {
            count += bit[index];
            index -= index & -index;
        }

        return count;
    }
}
