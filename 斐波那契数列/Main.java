//递归

class Solution {

    public int Fibonacci(int n) {

        if (n == 0) {

            return 0;
        }

        if (n == 1) {

            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.Fibonacci(4));
    }
}
