import java.util.Arrays;

//排序
class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) {

            return 0;
        }

        Arrays.sort(array);

        int pre = 0, next = 0;

        for(next=0; next<array.length; next++) {

            if(array[next] == array[pre]) {

            } else {

                pre = next;
            }

            if(next - pre + 1 > array.length/2) {

                return array[pre];
            }
        }

        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1};
        System.out.println(solution.MoreThanHalfNum_Solution(arr));
    }
}
