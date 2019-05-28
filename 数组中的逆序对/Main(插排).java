//原地插入排序求逆序对数 算法最坏时间复杂度O(n+d)=O(n+n*(n-1)/2)

class Solution {

    private int cnt = 0;

    public int InversePairs(int [] array) {

        for(int i=1; i<array.length; ++i) {

            for(int j=i; j>0&&array[j]<array[j-1]; j--) {

                exch(array, j, j-1);
            }
        }

        return cnt;
    }

    private void exch(int[] arr, int x, int y) {

        cnt = (cnt+1)%1000000007;
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
