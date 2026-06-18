class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > 1) {
                result.add(num);
            }
        }

        Collections.sort(result);
        return result;
    }
}