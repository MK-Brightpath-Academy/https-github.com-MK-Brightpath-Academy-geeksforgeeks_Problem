import java.util.*;

class Solution {

    ArrayList<Integer> findTwoElement(int arr[]) {

        int n = arr.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : arr) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long sumDiff = actualSum - expectedSum;              // R - M
        long squareDiff = actualSquareSum - expectedSquareSum; // R² - M²

        long sumRM = squareDiff / sumDiff;                   // R + M

        int repeating = (int) ((sumDiff + sumRM) / 2);
        int missing = (int) (sumRM - repeating);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);

        return ans;
    }
}