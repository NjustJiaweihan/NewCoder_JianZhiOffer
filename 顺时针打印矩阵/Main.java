class Solution {

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        //行列最大下标
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        int start = 0;
        int cnt = 0;

        while (col >= start * 2 && row >= start * 2) {

            circle(matrix, res, row, col, start, cnt);
            cnt++;
            start++;

        }

        return res;
    }

    public void circle(int[][] matrix, ArrayList<Integer> res, int row, int col, int start, int cnt) {

        //左->右
        for (int i = start; i <= col - cnt; i++) {

            res.add(matrix[start][i]);
        }

        //上->下
        if (start + 1 <= row - cnt) {

            for (int i = start + 1; i <= row - cnt; i++) {

                res.add(matrix[i][col - cnt]);
            }
        } else {

            return;
        }

        //右->左
        if (col - cnt - 1 >= cnt) {

            for (int i = col - cnt - 1; i >= cnt; i--) {

                res.add(matrix[row - cnt][i]);
            }
        } else {

            return;
        }

        //下->上
        if (row - cnt - 1 >= cnt + 1) {

            for (int i = row - cnt - 1; i >= cnt + 1; i--) {

                res.add(matrix[i][cnt]);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] matrix = {{1,2,3,4}};
        ArrayList<Integer> res = solution.printMatrix(matrix);

        for(Integer i : res) {

            System.out.print(i + " ");
        }
    }
}
