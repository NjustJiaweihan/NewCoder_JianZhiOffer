public class Solution {

    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flag = new int[rows][cols];
        int sum = 0;

        dfs(threshold, rows, cols, 0, 0, flag);

        for(int i=0; i<rows; i++){

            for(int j=0; j<cols; j++){

                sum += flag[i][j];
            }
        }

        return sum;
    }

    private void dfs(int threshold, int rows, int cols, int i, int j, int[][] flag){

        // 不要踩重复的格子 
        // 一种是降低了时间复杂度 
        // 一种是避免振荡: (3,0)-x->(4,0)->(3,0)->(2,0)->(3,0)-x->(4,0)->(3,0)->(2,0)
        if(i<0 || i>=rows || j<0 || j>=cols || cal(i, j) > threshold || flag[i][j] == 1){

            return;
        }

        flag[i][j] = 1;

        // 因为起点在左上角 所以可以省略两个方向的dfs
        dfs(threshold, rows, cols, i+1, j, flag);
        //dfs(threshold, rows, cols, i-1, j, flag);
        dfs(threshold, rows, cols, i, j+1, flag);
        //dfs(threshold, rows, cols, i, j-1, flag);

    }

    private int cal(int x, int y){

        int sum = 0;

        while (x != 0){

            sum += x % 10;
            x /= 10;
        }

        while (y != 0){

            sum += y % 10;
            y /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        // 15
        System.out.println(new 机器人的运动范围().movingCount(5, 4, 4));
    }
}
