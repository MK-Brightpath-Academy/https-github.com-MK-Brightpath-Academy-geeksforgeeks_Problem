class Solution {
    public boolean isValid(int mat[][]) {

        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];

            for (int j = 0; j < 9; j++) {
                int num = mat[i][j];

                if (num != 0) {
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];

            for (int i = 0; i < 9; i++) {
                int num = mat[i][j];

                if (num != 0) {
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        // Check 3x3 sub-grids
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                boolean[] seen = new boolean[10];

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {

                        int num = mat[i][j];

                        if (num != 0) {
                            if (seen[num]) {
                                return false;
                            }
                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}