class Solution {

    public int minInsAndDel(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        // Store positions of elements of b
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int j = 0; j < m; j++) {
            map.computeIfAbsent(b[j], k -> new ArrayList<>()).add(j);
        }

        // tails[k] = smallest ending position of
        // an increasing subsequence of length k + 1
        int[] tails = new int[Math.min(n, m)];
        int len = 0;

        for (int x : a) {

            ArrayList<Integer> positions = map.get(x);

            if (positions == null)
                continue;

            // Process positions from right to left
            for (int k = positions.size() - 1; k >= 0; k--) {

                int pos = positions.get(k);

                int left = 0;
                int right = len;

                while (left < right) {

                    int mid = left + (right - left) / 2;

                    if (tails[mid] < pos) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left == len) {
                    len++;
                }

                tails[left] = pos;
            }
        }

        int lcs = len;

        return n + m - 2 * lcs;
    }
}