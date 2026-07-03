class Solution {

    public static int findEquilibrium(int arr[]) {

        long totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            // Remove current element from right sum
            totalSum -= arr[i];

            // Check equilibrium
            if (leftSum == totalSum) {
                return i;
            }

            // Add current element to left sum
            leftSum += arr[i];
        }

        return -1;
    }
}