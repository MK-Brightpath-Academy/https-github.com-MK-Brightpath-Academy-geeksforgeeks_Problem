
class Solution {

    public ArrayList<String> wordBreak(String[] dict, String s) {

        HashSet<String> set = new HashSet<>();

        for (String word : dict) {
            set.add(word);
        }

        HashMap<Integer, ArrayList<String>> memo = new HashMap<>();

        return solve(0, s, set, memo);
    }

    private ArrayList<String> solve(
        int index,
        String s,
        HashSet<String> set,
        HashMap<Integer, ArrayList<String>> memo
    ) {

        ArrayList<String> result = new ArrayList<>();

        // Complete string processed
        if (index == s.length()) {
            result.add("");
            return result;
        }

        // Already calculated
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // Try every possible word
        for (int end = index + 1; end <= s.length(); end++) {

            String word = s.substring(index, end);

            if (set.contains(word)) {

                ArrayList<String> remaining =
                    solve(end, s, set, memo);

                for (String suffix : remaining) {

                    if (suffix.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + suffix);
                    }
                }
            }
        }

        memo.put(index, result);

        return result;
    }
}
