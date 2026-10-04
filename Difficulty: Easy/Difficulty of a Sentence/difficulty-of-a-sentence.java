class Solution {

    public int calcDiff(String s) {

        String[] words = s.split("\\s+");

        int hard = 0;
        int easy = 0;

        for (String word : words) {

            int vowels = 0;
            int consonants = 0;
            int consecutiveConsonants = 0;

            for (char ch : word.toLowerCase().toCharArray()) {

                if (isVowel(ch)) {

                    vowels++;
                    consecutiveConsonants = 0;

                } else {

                    consonants++;
                    consecutiveConsonants++;

                    if (consecutiveConsonants >= 4) {
                        break;
                    }
                }
            }

            boolean isHard =
                    consecutiveConsonants >= 4
                    || consonants > vowels;

            if (isHard) {
                hard++;
            } else {
                easy++;
            }
        }

        return 5 * hard + 3 * easy;
    }

    private boolean isVowel(char ch) {

        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }
}