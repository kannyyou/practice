package Q17_20_Continuous_Median;

public class NewSolution {
	/**Logical Thinking

	Median is the middle value in an ordered integer list, so median will halve the list, a bigger half and a smaller half. If the size of the list is even, median is the mean of the two middle value, i.e., the mean of the minimum of the bigger half and the maximum of the smaller half. PriorityQueue is designed for the case that we need to find the minimum or the maximum of a collection from time to time.
	So we maintain minPQ, the bigger half, and maxPQ, the smaller half. And we decide to maintain the minPQ larger if the size of list is odd.

	Clear Java Code
//*/
//	    PriorityQueue<Integer> minPQ; // the bigger half that always polls the minimum
//	    PriorityQueue<Integer> maxPQ; // the smaller half that always polls the maximum
//
//	    public MedianFinder() {
//	        minPQ = new PriorityQueue<>();
//	        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
//	    }
//
//	    public void addNum(int num) {
//	        minPQ.add(num);
//	        maxPQ.add(minPQ.poll());
//	        if (minPQ.size() < maxPQ.size()) {
//	            minPQ.add(maxPQ.poll());
//	        }
//	    }
//
//	    public double findMedian() {
//	        if (minPQ.size() > maxPQ.size()) {
//	            return minPQ.peek();
//	        }
//	        return (minPQ.peek() + maxPQ.peek()) / 2.0;
//	    }
}
