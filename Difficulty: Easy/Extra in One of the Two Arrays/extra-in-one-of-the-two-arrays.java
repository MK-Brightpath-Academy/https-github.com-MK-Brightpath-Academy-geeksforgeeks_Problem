class Solution {

    public int findExtra(int a[], int b[]) {

        for (int i = 0; i < b.length; i++) {

            if (a[i] != b[i]) {
                return i;
            }
        }

        // Extra element is at the end
        return a.length - 1;
    }
}