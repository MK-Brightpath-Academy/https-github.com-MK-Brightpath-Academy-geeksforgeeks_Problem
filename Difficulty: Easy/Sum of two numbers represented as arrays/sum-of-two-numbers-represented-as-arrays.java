import java.util.*;

class Solution {

    public ArrayList<Integer> addArrays(int[] arr1, int[] arr2) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += arr1[i];
                i--;
            }

            if (j >= 0) {
                sum += arr2[j];
                j--;
            }

            ans.add(sum % 10);
            carry = sum / 10;
        }

        // We calculated from right to left
        Collections.reverse(ans);

        // Remove leading zeroes
        while (ans.size() > 1 && ans.get(0) == 0) {
            ans.remove(0);
        }

        return ans;
    }
}