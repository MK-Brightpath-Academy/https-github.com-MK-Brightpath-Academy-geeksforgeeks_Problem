
import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int size = 4 * n;
        int total = size * size;

        ArrayList<Integer> coil1 = new ArrayList<>();

        int row = 0;
        int col = 0;

        // Start from top-left
        coil1.add(1);

        // Move downward along the first column
        for (int i = 1; i < size; i++) {
            row++;
            coil1.add(row * size + col + 1);
        }

        int len = size - 2;
        boolean rightFirst = true;

        // Follow the inward coil pattern
        while (len > 0) {
            if (rightFirst) {
                // Move right
                for (int i = 0; i < len; i++) {
                    col++;
                    coil1.add(row * size + col + 1);
                }

                // Move up
                for (int i = 0; i < len; i++) {
                    row--;
                    coil1.add(row * size + col + 1);
                }
            } else {
                // Move left
                for (int i = 0; i < len; i++) {
                    col--;
                    coil1.add(row * size + col + 1);
                }

                // Move down
                for (int i = 0; i < len; i++) {
                    row++;
                    coil1.add(row * size + col + 1);
                }
            }

            rightFirst = !rightFirst;
            len -= 2;
        }

        ArrayList<Integer> coil2 = new ArrayList<>();

        // Corresponding values form the second coil
        for (int value : coil1) {
            coil2.add(total + 1 - value);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(coil1);
        result.add(coil2);

        return result;
    }
}
