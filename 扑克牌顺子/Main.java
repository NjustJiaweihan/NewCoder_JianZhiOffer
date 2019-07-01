//debug时候可以将注释部分解开

public class Solution {
    public boolean isContinuous(int [] numbers) {

        if(numbers == null || numbers.length != 5) {

            return false;
        }
        /**
         * 寻找非零最小值和最大值
         */
        int max = -1, min = 14, zero = 0;
        for(int i=0; i<numbers.length; i++){

            if(numbers[i] != 0 && numbers[i] < min) {

                min = numbers[i];
            }

            if(numbers[i] > max){

                max = numbers[i];
            }

            if(numbers[i] == 0){

                zero++;
            }
        }

        if(zero == 4 || zero == 5) {

            return true;
        }
//        System.out.println("min: " + min + " max: " + max + " zero: " + zero);
        int[] res = new int[max+1];

        for(int i : numbers){

            if(i != 0) {
                res[i] = 1;
            }
        }

//        System.out.print("res: ");
//        for(int i : res){
//
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int cnt = 0;
        for(int i=min; i<=max; i++){

            if(res[i] == 0){

                cnt++;
            }
        }
        //System.out.println("cnt: " + cnt);
        return cnt == zero;
    }

//    public static void main(String[] args) {
//        new Solution().isContinuous(new int[]{0,2,3,5,6});
//    }
}
