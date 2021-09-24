package info.sandroalmeida.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class ContinuousMedian {

    static class ContinuousMedianHandler {
        double median = 0;
        Queue<Integer> lowMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> greatMinHeap = new PriorityQueue<>((a, b) -> a - b);

        public void insert(int number) {
            if(lowMaxHeap.size() == 0 || number < lowMaxHeap.peek())
                lowMaxHeap.add(number);
            else
                greatMinHeap.add(number);
            rebalanceHeaps();
            updateMedian();
        }

        public void rebalanceHeaps() {
            if(lowMaxHeap.size() - greatMinHeap.size() == 2)
                greatMinHeap.add(lowMaxHeap.poll());
            else if(greatMinHeap.size() - lowMaxHeap.size() == 2)
                lowMaxHeap.add(greatMinHeap.poll());
        }

        public void updateMedian() {
            if(lowMaxHeap.size() == greatMinHeap.size())
                median = ((double) lowMaxHeap.peek() + (double) greatMinHeap.peek()) / 2;
            else if(lowMaxHeap.size() > greatMinHeap.size())
                median = lowMaxHeap.peek();
            else
                median = greatMinHeap.peek();
        }

        public double getMedian() {
            return median;
        }
    }
}
