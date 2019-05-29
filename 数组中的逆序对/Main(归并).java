//求模位置还没弄清楚

class Solution {

    //将aux作为实例变量 可以避免在递归体中重复new
    private int[] aux;

    public int InversePairs(int[] array) {

        if (array == null || array.length == 0) {

            return 0;
        }

        aux = new int[array.length];

        return InversePairs(array, 0, array.length - 1);
    }

    private int InversePairs(int[] arr, int from, int to) {

        if (from >= to) {

            return 0;
        }

        int mid = (from + to) / 2;

        int left = InversePairs(arr, from, mid) % 1000000007;
        int right = InversePairs(arr, mid + 1, to) % 1000000007;
        int cnt = merge(arr, from, mid, to);

        //总的逆序对数 = 左半逆序对数 + 右半逆序对数 + 二路归并统计得到的逆序对数
        return (left + right + cnt) % 1000000007;
    }

    //基本二路归并 非原地
    private int merge(int[] arr, int from, int mid, int to) {

        for (int k = from; k <= to; ++k) {

            aux[k] = arr[k];
        }

        int i = from, j = mid + 1, cnt = 0;

        for (int k = from; k <= to; ++k) {

            if (i > mid) {

                arr[k] = aux[j++];

            } else if (j > to) {

                arr[k] = aux[i++];

            } else if (aux[i] < aux[j]) {

                arr[k] = aux[i++];

            } else {
                //左路第i个元素 > 右路第j个元素
                //那左路剩下的所有元素都大于右路
                arr[k] = aux[j++];
                cnt += mid - i + 1;
                if (cnt >= 1000000007) {

                    cnt %= 1000000007;
                }
            }
        }

        return cnt;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        
        System.out.println(solution.InversePairs(new int[]{5, 6, 7, 8, 1, 2, 3, 4}));
    }
}
