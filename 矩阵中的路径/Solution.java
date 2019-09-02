public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] flag = new int[matrix.length];

        for(int i=0; i<rows; i++){

            for(int j=0; j<cols; j++){

                if(dfs(matrix, rows, cols, str, i, j, flag, 0))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[] matrix, int rows, int cols, char[] str, int i, int j, int[] flag, int k){

        int index = i * cols + j;
        if(i<0 || i>=rows || j<0 || j>=cols || flag[index]==1 || matrix[index]!=str[k]){

            return false;

        }

        if(matrix[index]==str[k] && k == str.length-1){

            return true;
        }

        flag[index] = 1;
        k++;

        if(dfs(matrix, rows, cols, str, i-1, j, flag, k)
                || dfs(matrix, rows, cols, str, i+1, j, flag, k)
                || dfs(matrix, rows, cols, str, i, j-1, flag, k)
                || dfs(matrix, rows, cols, str, i, j+1, flag, k)){

            return true;
        }

        flag[index] = 0;
        return false;
    }
}
