//TODO 优化一下
public class Solution {

    public int GetNumberOfK(int [] array , int k) {

        int indexOfFirstk = getFirstk(array, k, 0, array.length-1);
        int indexOfLastk = getLastk(array, k, 0, array.length-1);
        
        if(indexOfFirstk!=-1 && indexOfLastk!=-1) {
            
            return indexOfLastk-indexOfFirstk+1;
        } else {
            
            return 0;
        }
        
    }

    private int getFirstk(int[] arr, int k, int lo, int hi) {



        while (lo <= hi) {

            int mid = (lo + hi) >> 1;

            if(arr[mid] > k) {

                hi = mid - 1;

            } else if(arr[mid] < k){

                lo = mid + 1;

            } else {

                if(mid>0 && arr[mid-1] != k || mid==0) {

                    return mid;

                } else {

                    hi = mid-1;
                }
            }
        }
        return -1;
    }

    private int getLastk(int[] arr, int k, int lo, int hi) {



        while (lo <= hi) {

            int mid = (lo + hi) >> 1;

            if(arr[mid] > k) {

                hi = mid - 1;

            } else if(arr[mid] < k){

                lo = mid + 1;

            } else {

                if(mid<arr.length-1 && arr[mid+1] != k || mid==arr.length-1) {

                    return mid;

                } else {

                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
