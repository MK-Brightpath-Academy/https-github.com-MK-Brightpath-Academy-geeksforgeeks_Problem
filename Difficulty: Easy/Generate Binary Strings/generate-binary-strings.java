class Solution {
    public ArrayList<String> generateStrings(String s) {
        ArrayList<String> result = new ArrayList<>();
        generate(s, 0, result);
        return result;
    }

    private void generate(String s, int index, ArrayList<String> result) {
        if (index == s.length()) {
            result.add(s);
            return;
        }

        if (s.charAt(index) == '?') {
            // ? ko 0 se replace karo
            StringBuilder str = new StringBuilder(s);
            str.setCharAt(index, '0');
            generate(str.toString(), index + 1, result);

            // ? ko 1 se replace karo
            str.setCharAt(index, '1');
            generate(str.toString(), index + 1, result);
        } else {
            // Normal character hai, same rakho
            generate(s, index + 1, result);
        }
    }
}