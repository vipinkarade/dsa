package heapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder
{
	boolean isEven;
	PriorityQueue<Integer> firstHalf;
	PriorityQueue<Integer> secondHalf;
	public MedianFinder() {
		isEven = true;
		firstHalf = new PriorityQueue<>(Comparator.reverseOrder());
		secondHalf = new PriorityQueue<>();
	}

	public void addNum(int num) {
		isEven = !isEven;
		secondHalf.add(num);
		if (isEven)
			firstHalf.add(secondHalf.poll());

		if (!firstHalf.isEmpty() && firstHalf.peek() > secondHalf.peek())
		{
			firstHalf.add(secondHalf.poll());
			secondHalf.add(firstHalf.poll());
		}
	}

	public double findMedian() {
		if (!isEven)
			return (double) secondHalf.peek();
		else
		{
			return ((double) firstHalf.peek() + (double) secondHalf.peek()) / 2;
		}
	}
}
