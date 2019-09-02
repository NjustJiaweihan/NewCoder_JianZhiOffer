import java.util.*;

public class Solution{

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length == 0 || size <= 0 || num.length < size){
            return new ArrayList<>();
        }

        //双端队列中存的是索引！
        LinkedList<Integer> window = new LinkedList<>();

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<num.length; i++){

            //从右边开始 把<=num[i]的都poll
            while (!window.isEmpty() && num[window.peekLast()]<num[i]){

                window.pollLast();
            }
            window.addLast(i);

            //从左边将过期的都poll
            if (window.peekFirst() == i - size){

                window.pollFirst();
            }

            if(i >= size - 1){

                res.add(num[window.peekFirst()]);
            }
        }
        return res;
    }
}
