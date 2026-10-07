import java.util.*;

class Solution {

    static int findNumberOfTriangles(int arr[]) {

        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        // k = largest side
        for (int k = n - 1; k >= 2; k--) {

            int i = 0;
            int j = k - 1;

            while (i < j) {

                if (arr[i] + arr[j] > arr[k]) {

                    // All elements from i to j-1
                    // can form a triangle with j and k
                    count += j - i;

                    j--;

                } else {

                    i++;
                }
            }
        }

        return count;
    }
}