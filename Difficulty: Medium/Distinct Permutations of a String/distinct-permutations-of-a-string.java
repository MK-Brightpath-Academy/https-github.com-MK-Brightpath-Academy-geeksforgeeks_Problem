class Solution {

    public ArrayList<String> findPermutation(String s) {

        ArrayList<String> ans = new ArrayList<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        boolean[] visited = new boolean[arr.length];

        backtrack(arr, visited, new StringBuilder(), ans);

        return ans;
    }

    private void backtrack(char[] arr,
                           boolean[] visited,
                           StringBuilder curr,
                           ArrayList<String> ans) {

        if (curr.length() == arr.length) {
            ans.add(curr.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i])
                continue;

            // Skip duplicate characters
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            curr.append(arr[i]);

            backtrack(arr, visited, curr, ans);

            curr.deleteCharAt(curr.length() - 1);
            visited[i] = false;
        }
    }
}