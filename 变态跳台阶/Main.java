class Solution {

    public int JumpFloorII(int target) {

        if(target == 0 || target == 1 || target == 2) {

            return target;
        }

        int[] res = new int[target+1];
        //res[0]要设置成1
        //比如f(3)=f(3-1)+f(3-2)+f(3-3)=f(2)+f(1)+f(0)
        //此时的f(3-3)表示第一步跳3台阶 应该也是一种解 所以f(0)应该设置成1
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for(int i=3; i<target+1; i++) {

            //f(n)=f(n-1)+f(n-2)+...+f(0)
            //f(n-1)=f(n-2)+...+f(0)
            //f(n)=2*f(n-1)
            res[i] = 2 * res[i-1];
        }

        return res[target];
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.JumpFloorII(5));
    }
}
