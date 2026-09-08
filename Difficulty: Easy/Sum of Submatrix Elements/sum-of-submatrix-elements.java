class Solution {
    public int subMatrixSum(int[][] arr, int x1, int y1, int x2, int y2) {
        int sum = 0;

        // Convert 1-based indexing to 0-based indexing
        for (int i = x1 - 1; i <= x2 - 1; i++) {
            for (int j = y1 - 1; j <= y2 - 1; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }
}