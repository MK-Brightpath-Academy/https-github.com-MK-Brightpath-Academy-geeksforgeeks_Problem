class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length + 1;

        for (int i = 2; i <= n; i++) {
            int user = i;
            int[] distance = new int[n + 1];

            int steps = 0;

            while (user != 1) {
                int friend = arr[user - 2];
                steps++;
                distance[friend] = steps;
                user = friend;
            }

            for (int j = 1; j < i; j++) {
                if (distance[j] > 0) {
                    ArrayList<Integer> path = new ArrayList<>();
                    path.add(i);
                    path.add(j);
                    path.add(distance[j]);

                    result.add(path);
                }
            }
        }

        return result;
    }
}