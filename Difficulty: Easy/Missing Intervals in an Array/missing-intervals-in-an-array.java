import java.util.*;

class Solution {

    public List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {

        List<List<Integer>> result = new ArrayList<>();

        long prev = (long) lower - 1;

        for (int num : arr) {

            if (num - prev >= 2) {
                result.add(Arrays.asList(
                    (int) (prev + 1),
                    num - 1
                ));
            }

            prev = num;
        }

        // Check remaining range
        if (upper - prev >= 1) {
            result.add(Arrays.asList(
                (int) (prev + 1),
                upper
            ));
        }

        return result;
    }
}