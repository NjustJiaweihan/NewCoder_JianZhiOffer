class Solution {

    public void reOrderArray(int[] array) {

        if (array == null || array.length == 0 || array.length == 1) {

            return;
        }

        //  index指向的是每一个待确认的元素
        int index = 0;

        for (int i = 0; i < array.length; ++i) {

            if (array[index] % 2 == 0) {

                move(index, array);

            } else {

                index++;
            }
        }
    }

    public void move(int index, int[] array) {

        for (int j = index; j < array.length-1; j++) {

            int temp = array[j];
            array[j] = array[j + 1];
            array[j+1] = temp;

        }
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,7};
        solution.reOrderArray(arr);

        for(int i : arr) {

            System.out.print(i + " ");
        }
    }
}
