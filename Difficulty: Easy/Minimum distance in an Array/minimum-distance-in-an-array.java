class Solution {
    int minDist(int arr[], int x, int y) {
        int lastX = -1;
        int lastY = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x) {
                lastX = i;

                if (lastY != -1) {
                    minDistance = Math.min(minDistance, lastX - lastY);
                }
            }

            if (arr[i] == y) {
                lastY = i;

                if (lastX != -1) {
                    minDistance = Math.min(minDistance, lastY - lastX);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}