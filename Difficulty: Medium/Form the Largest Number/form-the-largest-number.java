import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        String[] nums = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // If all numbers are 0
        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (String num : nums) {
            result.append(num);
        }

        return result.toString();
    }
}