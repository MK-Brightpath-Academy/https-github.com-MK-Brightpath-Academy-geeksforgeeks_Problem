class Solution {
    public ArrayList<Integer> frequencyCount(int[] arr) {

        int n = arr.length;
        int[] freq = new int[n];

        for (int num : arr) {
            if (num >= 1 && num <= n) {
                freq[num - 1]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int count : freq) {
            ans.add(count);
        }

        return ans;
    }
}