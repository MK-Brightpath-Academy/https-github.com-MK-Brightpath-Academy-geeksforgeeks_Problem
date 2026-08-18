class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        Arrays.sort(arr);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            result.add(arr[i]);
        }

        return result;
    }
}