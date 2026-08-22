/*
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
*/
class Solution {
    public pair[] allPairs(int target, int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency of elements in arr2
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<pair> result = new ArrayList<>();

        // Find pairs
        for (int num : arr1) {

            int required = target - num;

            if (map.containsKey(required)) {

                int frequency = map.get(required);

                // Add pair for every occurrence
                for (int i = 0; i < frequency; i++) {
                    result.add(new pair(num, required));
                }
            }
        }

        // Sort according to first element
        Collections.sort(result,
            (a, b) -> Long.compare(a.first, b.first));

        return result.toArray(new pair[0]);
    }
}

