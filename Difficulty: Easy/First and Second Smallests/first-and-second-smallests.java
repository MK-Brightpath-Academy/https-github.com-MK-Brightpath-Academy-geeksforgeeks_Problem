import java.util.*;

class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                second = first;
                first = num;
            } 
            else if (num > first && num < second) {
                second = num;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (second == Integer.MAX_VALUE) {
            result.add(-1);
        } else {
            result.add(first);
            result.add(second);
        }

        return result;
    }
}