
class Solution {
    public int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // Update histogram heights
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Find maximum rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangle(height));
        }

        return maxArea;
    }

    private int largestRectangle(int[] height) {
        int n = height.length;
        int[] stack = new int[n];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : height[i];

            while (top != -1 &&
                   height[stack[top]] >= currentHeight) {

                int h = height[stack[top--]];
                int width = (top == -1)
                        ? i
                        : i - stack[top] - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxArea;
    }
}
