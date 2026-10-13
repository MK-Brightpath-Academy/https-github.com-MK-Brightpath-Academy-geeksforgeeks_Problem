class Solution {
    public ArrayList<ArrayList<Integer>> equalPartition(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int num : arr) {
            total += num;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (total % 2 != 0) {
            return result;
        }

        boolean[] chosen = new boolean[n];
        int requiredCount = n / 2;

        if (findPartition(arr, 0, requiredCount,
                          total / 2, chosen)) {

            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (chosen[i]) {
                    first.add(arr[i]);
                } else {
                    second.add(arr[i]);
                }
            }

            result.add(first);
            result.add(second);
        }

        return result;
    }

    private boolean findPartition(
            int[] arr, int index, int count,
            int target, boolean[] chosen) {

        if (count == 0) {
            return target == 0;
        }

        if (index == arr.length ||
            arr.length - index < count) {
            return false;
        }

        // Include current element
        chosen[index] = true;

        if (findPartition(arr, index + 1, count - 1,
                          target - arr[index], chosen)) {
            return true;
        }

        // Exclude current element
        chosen[index] = false;

        if (findPartition(arr, index + 1, count,
                          target, chosen)) {
            return true;
        }

        return false;
    }
}
