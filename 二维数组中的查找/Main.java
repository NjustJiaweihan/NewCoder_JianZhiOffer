class Solution {

    public boolean Find(int target, int[][] array) {

        int row = array.length - 1;
        int col = 0;

        while (row >= 0 && col < array[0].length) {

            if (array[row][col] == target) {

                return true;
            } else if (array[row][col] > target) {
                row--;
            } else {

                col++;
            }
        }

        return false;
    }
}

public class Main
{
    public static void main(String[] args) {

        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        Solution solution = new Solution();

        System.out.println(solution.Find(7, arr));
    }
}
