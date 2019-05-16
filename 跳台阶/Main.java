class Solution {

    //JumpFloor(n)表示n台阶有多少种跳法 = 第一次跳1个台阶的总跳法 + 第一次跳2个台阶的总跳法
    //JumpFloor(n) = JumpFloor(n-1) + JumpFloor(n-2)
    //青蛙跳台阶就是斐波那契数列问题

    public int JumpFloor(int target) {

        if (target == 0 || target == 1 || target == 2) {

            return target;
        }

        int[] res = new int[target + 1];

        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i < target + 1; ++i) {

            res[i] = res[i - 1] + res[i - 2];
        }

        return res[target];
    }
}
