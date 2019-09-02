import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {


    private PriorityQueue<Integer> min = new PriorityQueue();

    private PriorityQueue<Integer> max = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int cnt;

    public void Insert(Integer num) {

        //保持大顶+小顶 偶奇

        if(cnt % 2 == 0){

            max.add(num);
            int temp = max.poll();
            min.add(temp);

        } else {

            min.offer(num);
            int temp = min.poll();
            max.add(temp);
        }

        cnt++;
    }

    public Double GetMedian() {

        if(cnt % 2 == 0){

            return (min.peek() + max.peek()) / 2.0;
        } else {

            return (double) min.peek();
        }
    }
}
