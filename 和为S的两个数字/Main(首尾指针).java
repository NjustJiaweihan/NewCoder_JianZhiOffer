import java.util.ArrayList;

class Solution {
    
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
        int head = 0, tail = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        
        while (head <= tail) {

            if(array[head] + array[tail] < sum) {

                head++;

            } else if(array[head] + array[tail] > sum) {

                tail--;
                
            } else {

                res.add(array[head]);
                res.add(array[tail]);
                break;
            }
        }
        return res;
    }
}

//a+b=sum b-a越大 a*b越小？

/*
y = a*b = a*(sum-a)
y' = sum-2*a = 0
a = sum/2时 y' = 0 y取得最大值 此时a=b=sum/2
所以b-a最大时 y最小
*/
