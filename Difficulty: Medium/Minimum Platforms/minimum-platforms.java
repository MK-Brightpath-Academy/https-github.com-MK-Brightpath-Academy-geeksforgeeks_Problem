import java.util.Arrays;

class Solution {

    static int minPlatform(int arr[], int dep[]) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;

        int platforms = 1;
        int maxPlatforms = 1;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}