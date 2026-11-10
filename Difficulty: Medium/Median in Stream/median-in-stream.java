
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>();

        ArrayList<Double> result = new ArrayList<>();

        for (int num : arr) {

            // Step 1: Insert element
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Step 2: Balance both heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } 
            else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }

            // Step 3: Calculate median
            if (maxHeap.size() > minHeap.size()) {

                result.add((double) maxHeap.peek());

            } 
            else if (minHeap.size() > maxHeap.size()) {

                result.add((double) minHeap.peek());

            } 
            else {

                double median =
                    ((double) maxHeap.peek() + minHeap.peek()) / 2.0;

                result.add(median);
            }
        }

        return result;
    }
}
