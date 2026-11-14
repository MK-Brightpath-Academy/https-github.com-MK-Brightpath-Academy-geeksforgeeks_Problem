
class Solution {

    public void setMatrixZeroes(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Check first row
        boolean firstRowZero = false;

        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check first column
        boolean firstColZero = false;

        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Mark rows and columns
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (mat[i][j] == 0) {

                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Step 4: Set zeroes using markers
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (mat[i][0] == 0 ||
                    mat[0][j] == 0) {

                    mat[i][j] = 0;
                }
            }
        }

        // Step 5: Update first row
        if (firstRowZero) {

            for (int j = 0; j < n; j++) {
                mat[0][j] = 0;
            }
        }

        // Step 6: Update first column
        if (firstColZero) {

            for (int i = 0; i < m; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
