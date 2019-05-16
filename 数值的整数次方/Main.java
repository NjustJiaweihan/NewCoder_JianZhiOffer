class Solution {

    public double Power(double base, int exponent) {

        double res = 1.0;

        if(exponent == 0) {

            return 1.0;
        }

        if(exponent < 0) {

            base = 1 / base;
            exponent = - exponent;
        }

        for(int i=0; i<exponent; i++) {

            res *= base;
        }
        return res;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        double res = solution.Power(3.2, 2);

        System.out.println("我算的 " + res);
        System.out.println("真正的 " + Math.pow(3.2, 2.0));
    }
}
