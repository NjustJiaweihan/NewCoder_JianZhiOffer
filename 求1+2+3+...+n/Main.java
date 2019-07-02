public class Solution {

    public int Sum_Solution(int n) {

        return sum(n);
    }

    private int sum(int n){

        if(n == 0){

            return 0;
        }

        return n + sum(n-1);
    }
}
