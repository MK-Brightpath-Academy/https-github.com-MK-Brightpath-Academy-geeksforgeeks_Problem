import java.util.*;

class Solution {

    public String replace(String s,
                          ArrayList<Integer> idx,
                          ArrayList<String> src,
                          ArrayList<String> tar) {

        // Store index with corresponding source and target
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < idx.size(); i++) {
            order.add(i);
        }

        // Sort according to index
        order.sort((a, b) -> idx.get(a) - idx.get(b));

        StringBuilder result = new StringBuilder();

        int current = 0;

        for (int i : order) {

            int pos = idx.get(i);
            String source = src.get(i);
            String target = tar.get(i);

            // Already covered by previous replacement
            if (pos < current) {
                continue;
            }

            // Check whether source actually matches
            if (s.startsWith(source, pos)) {

                // Add unchanged part before replacement
                result.append(s, current, pos);

                // Add target
                result.append(target);

                // Move current pointer
                current = pos + source.length();
            }
        }

        // Add remaining part of original string
        result.append(s, current, s.length());

        return result.toString();
    }
}