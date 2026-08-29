import java.util.*;

class Solution {
    int closest3Sum(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;

        int closest = arr[0] + arr[1] + arr[2];

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                int currentDiff = Math.abs(sum - target);
                int closestDiff = Math.abs(closest - target);

                // Update if:
                // 1. Current sum is closer
                // 2. Both are equally close, but current sum is larger
                if (currentDiff < closestDiff ||
                    (currentDiff == closestDiff && sum > closest)) {

                    closest = sum;
                }

                // Exact match
                if (sum == target) {
                    return sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }
}