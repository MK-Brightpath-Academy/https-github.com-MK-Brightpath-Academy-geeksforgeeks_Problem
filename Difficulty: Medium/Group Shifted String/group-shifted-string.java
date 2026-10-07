class Solution {

    public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {

        HashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (String s : arr) {

            String key = getPattern(s);

            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String getPattern(String s) {

        if (s.length() == 1) {
            return "single";
        }

        StringBuilder key = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {

            int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;

            key.append(diff).append('#');
        }

        return key.toString();
    }
}