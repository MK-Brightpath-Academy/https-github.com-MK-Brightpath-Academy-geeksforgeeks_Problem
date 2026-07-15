import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        int n = arr1.length, m = arr2.length;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i])
                    ans.add(arr1[i]);
                i++;
            } 
            else if (arr1[i] > arr2[j]) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != arr2[j])
                    ans.add(arr2[j]);
                j++;
            } 
            else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i])
                    ans.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i])
                ans.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != arr2[j])
                ans.add(arr2[j]);
            j++;
        }

        return ans;
    }
}