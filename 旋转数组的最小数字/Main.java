//O(N)

class Solution {

    public int minNumberInRotateArray(int [] array) {

        if(array == null || array.length == 0) {

            return 0;
        }

        for(int i=1; i<array.length; ++i) {

            if(array[i] < array[i-1]) {

                return array[i];
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};
        Solution solution = new Solution();

        System.out.println(solution.minNumberInRotateArray(arr));
    }
}
