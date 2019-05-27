class Solution {

    public String PrintMinNumber(int[] numbers) {

        for (int pre = 0; pre < numbers.length; pre++) {

            for (int next = pre + 1; next < numbers.length; next++) {

                if (more(numbers[pre], numbers[next])) {

                    exch(numbers, pre, next);
                }
            }
        }

        StringBuffer s = new StringBuffer();
        for (int i : numbers) {

            s.append(i);
        }

        return s.toString();
    }

    public boolean more(int x, int y) {

        return Integer.parseInt(x + "" + y) > Integer.parseInt(y + "" + x);
    }

    private void exch(int[] num, int x, int y) {

        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {3, 32, 321};
        System.out.println(solution.PrintMinNumber(arr));
    }
}
