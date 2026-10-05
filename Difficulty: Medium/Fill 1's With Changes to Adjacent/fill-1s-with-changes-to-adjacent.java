import java.util.*;

class Solution {

    public int minMoves(List<Integer> arr) {

        int n = arr.size();

        // If there is no 1, conversion is impossible
        boolean hasOne = false;

        for (int num : arr) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return -1;
        }

        int maxMoves = 0;
        int zeros = 0;

        for (int i = 0; i < n; i++) {

            if (arr.get(i) == 0) {
                zeros++;
            } else {

                // A group of zeros has ended
                if (zeros > 0) {

                    if (i - zeros == 0) {
                        // Zeros are at the beginning
                        // Only right-side 1 can convert them
                        maxMoves = Math.max(maxMoves, zeros);

                    } else {
                        // Zeros are between two 1s
                        maxMoves = Math.max(
                            maxMoves,
                            (zeros + 1) / 2
                        );
                    }
                }

                zeros = 0;
            }
        }

        // Handle zeros at the end
        if (zeros > 0) {
            maxMoves = Math.max(maxMoves, zeros);
        }

        return maxMoves;
    }
}