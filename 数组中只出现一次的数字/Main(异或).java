//首先对于数组中只有一个单身数字的话Arr1 直接异或就可以了
//那两个单身数字的话Arr2 要是能变成两个上述数组的话就好了
//怎么变呢？
//Arr2全体异或的结果为num num!=0 则num二进制形式某一位一定为1 只有0^1=1
//这一位就是俩单身汉的区别 借此就可以讲单身汉一号和单身汉二号区分开了
//那为啥子数组中其他数字都是成双成对的呢 因为夫妻数字的这个某一位一定相同啊 分组也分不开它们啦

class Solution {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if(array == null || array.length < 2) {

            return;
        }
        num1[0] = num2[0] = 0;

        int num = 0;
        for(int i : array) {

            num ^= i;
        }

        int index = 0;
        while ((num & 1) == 0 && index < 32) {

            num = num >> 1;
            index++;
        }

        for(int i : array) {

            if(isArrayOne(i, index)){

                num1[0] ^= i;

            } else {

                num2[0] ^= i;
            }
        }
    }

    private boolean isArrayOne(int i, int index) {

        i = i >> index;

        return (i & 1) == 0;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2,3,3,4,4};
        int[] num1 = {1};
        int[] num2 = {1};
        solution.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
