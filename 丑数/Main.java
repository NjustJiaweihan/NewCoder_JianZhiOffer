class Solution {

    public int GetUglyNumber_Solution(int index) {

        if(index <= 0) {

            return 0;
        }

        int[] UglyNums = new int[index];
        UglyNums[0] = 1;
        int T2 = 0;
        int T3 = 0;
        int T5 = 0;

        for(int i=1; i<index; i++) {

            UglyNums[i] = min(UglyNums[T2]*2, UglyNums[T3]*3, UglyNums[T5]*5);

            while (UglyNums[T2] * 2 <= UglyNums[i]) {

                ++T2;
            }
            while (UglyNums[T3] * 3 <= UglyNums[i]) {

                ++T3;
            }
            while (UglyNums[T5] * 5 <= UglyNums[i]) {

                ++T5;
            }
        }

        return UglyNums[index-1];
    }

    private int min(int num1, int num2, int num3) {

        int temp = num1 < num2 ? num1 : num2;

        return temp < num3 ? temp : num3;
    }
}
