class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (arr.length == 0)
            return ans;

        ans.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}