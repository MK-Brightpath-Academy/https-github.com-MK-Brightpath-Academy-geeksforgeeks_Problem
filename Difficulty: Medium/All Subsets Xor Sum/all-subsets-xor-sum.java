
class Solution {
    int subsetXORSum(int arr[]) {
        int or = 0;

        for (int num : arr) {
            or |= num;
        }

        return or * (1 << (arr.length - 1));
    }
}
