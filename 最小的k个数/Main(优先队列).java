import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//优先队列
class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(input == null || input.length == 0 || k > input.length) {

            return new ArrayList<>();
        }

        Queue<Integer> res = new PriorityQueue<>(k + 1, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0; i<k; i++) {

            res.add(input[i]);
        }

        for(int i=k; i<input.length; i++) {

            res.add(input[i]);
            res.poll();
        }

        return new ArrayList<>(res);
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] input = {4,5,1,6,2,7,3,8,9,10};
        System.out.println(solution.GetLeastNumbers_Solution(input, 4));
    }
}
