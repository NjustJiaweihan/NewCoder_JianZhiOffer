import java.util.ArrayList;
class Solution {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer> > res = new ArrayList<>();

        int from = 1, to = 2;

        while (from <= sum/2) {

            int curSum = (from + to)*(to - from + 1)>>1;

            if(curSum < sum) {

                to++;

            } else if (curSum > sum) {

                from++;

            } else {

                ArrayList<Integer> temp = new ArrayList<>();

                for(int i=from; i<=to; i++) {

                    temp.add(i);
                }

                res.add(temp);
                to++;
            }
        }

        return res;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ArrayList res = solution.FindContinuousSequence(100);

        System.out.println(res);
    }
}
