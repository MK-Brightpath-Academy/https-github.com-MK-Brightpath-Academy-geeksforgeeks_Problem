class Solution {

    public ArrayList<String> justifyText(String[] words, int l) {

        ArrayList<String> result = new ArrayList<>();

        int n = words.length;
        int i = 0;

        while (i < n) {

            // Find how many words can fit in this line
            int j = i;
            int wordsLength = 0;

            while (j < n) {

                int requiredLength = wordsLength
                        + words[j].length()
                        + (j - i);   // minimum 1 space between words

                if (requiredLength > l) {
                    break;
                }

                wordsLength += words[j].length();
                j++;
            }

            // Number of words in this line
            int count = j - i;

            // Last line -> left justified
            if (j == n) {

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {

                    if (k > i) {
                        line.append(" ");
                    }

                    line.append(words[k]);
                }

                // Add remaining spaces at the end
                while (line.length() < l) {
                    line.append(" ");
                }

                result.add(line.toString());

                break;
            }

            // Only one word -> left justified
            if (count == 1) {

                StringBuilder line = new StringBuilder(words[i]);

                while (line.length() < l) {
                    line.append(" ");
                }

                result.add(line.toString());

            } else {

                // Total extra spaces
                int extraSpaces = l - wordsLength;

                // Number of gaps
                int gaps = count - 1;

                int spacesPerGap = extraSpaces / gaps;
                int remaining = extraSpaces % gaps;

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        // Left gaps get one extra space
                        if (k - i < remaining) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }

                result.add(line.toString());
            }

            i = j;
        }

        return result;
    }
}