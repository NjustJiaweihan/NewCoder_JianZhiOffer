class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {

            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; ++i) {

            sum += array[i];
            if (sum > max) {

                max = sum;
            }
            if (sum < 0) {

                sum = 0;
            }
        }

        return max;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(solution.FindGreatestSumOfSubArray(arr));
    }
}
