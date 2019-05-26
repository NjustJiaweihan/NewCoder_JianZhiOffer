//切分
class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {

        if(array == null || array.length == 0) {

            return 0;
        }

        if(array.length == 1) {

            return array[0];
        }

        int lo = 0, hi = array.length-1;

        while (lo < hi) {

            int index = partion(array, lo, hi);

            if(index == array.length/2)
            {
                if(isValid(array, array[index])) {

                    return array[index];

                } else {

                    return 0;
                }


            } else if(index < array.length/2) {

                lo = index + 1;
                partion(array, lo, hi);

            } else {

                hi = index - 1;
                partion(array, lo, hi);
            }
        }

        return 0;
    }

    private int partion(int[] arr, int lo, int hi) {

        int v = arr[lo];

        int i = lo, j = hi + 1;

        while (true) {

            while (arr[++i] < v) {

                if(i == hi) {

                    break;
                }
            }

            while (arr[--j] > v) {

                if(j == lo) {

                    break;
                }
            }

            if(i >= j) {

                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[lo];
        arr[lo] = arr[j];
        arr[j] = temp;

        return j;
    }

    private boolean isValid (int[] arr, int number) {

        int cnt = 0;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] == number) {

                cnt ++;
            }
        }

        return cnt > arr.length/2;
    }
}

//该代码在测试用例{1,2}会报错 TODO
public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2};
        System.out.println(solution.MoreThanHalfNum_Solution(arr));
    }
}
