import java.util.*;

class Solution {
    
    public List<Integer> firstNegInt(int[] arr, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            
            // Add current element's index if it is negative
            if (arr[i] < 0) {
                dq.addLast(i);
            }

            // Remove indices which are outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Window of size k is formed
            if (i >= k - 1) {
                
                if (!dq.isEmpty()) {
                    ans.add(arr[dq.peekFirst()]);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;
    }
}