import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.offer(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}