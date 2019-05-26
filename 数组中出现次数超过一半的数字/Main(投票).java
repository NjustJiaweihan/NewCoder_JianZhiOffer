//投票

class Solution {
    
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array == null || array.length == 0) {

            return 0;
        }

        int cnt = 1;
        int number = array[0];
        
        for(int i=1; i<array.length; i++) {

            if(array[i] != number) {

                cnt--;
                if(cnt == 0) {

                    number = array[i];
                    cnt = 1;
                }
            } else {

                cnt++;
            }
        }

        return isValid(array, number) ? number : 0;
    }

    private boolean isValid (int[] arr, int number) {

        int cnt = 0;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] == number) {

                cnt++;
            }
        }

        return cnt > arr.length/2;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(solution.MoreThanHalfNum_Solution(arr));
    }
}
