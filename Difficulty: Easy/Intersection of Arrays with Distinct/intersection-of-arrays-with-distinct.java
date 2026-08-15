import java.util.*;

class Solution {
    public int intersectSize(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : a) {
            set.add(x);
        }

        HashSet<Integer> common = new HashSet<>();

        for (int x : b) {
            if (set.contains(x)) {
                common.add(x);
            }
        }

        return common.size();
    }
}