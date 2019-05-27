//递归
class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n <= 0) {

            return 0;
        }
        if (n < 10) {

            return 1;
        }

        String s = n + "";

        int cnt = 0;

        //s.substring(1) ~ s

        //最高位1的个数
        if (s.charAt(0) > '1') {

            cnt += pow10(s.length() - 1);
        } else {

            cnt += Integer.parseInt(s.substring(1)) + 1;
        }

        //非最高位1的个数
        cnt += (s.charAt(0) - '0') * (s.length() - 1) * pow10(s.length() - 2);

        cnt += NumberOf1Between1AndN_Solution(Integer.parseInt(s.substring(1)));

        return cnt;
    }

    //10的幂
    private int pow10(int n) {

        int res = 1;

        for (int i = 0; i < n; i++) {

            res *= 10;
        }

        return res;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(121));
    }
}
