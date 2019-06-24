class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        int res = 0;
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i : array) {

            if(binarySearch(array, sum-i)) {

                if(nums.size() == 0) {

                    nums.add(i);
                    nums.add(sum-i);

                } else if(i * (sum-i) < res) {

                    nums.add(i);
                    nums.add(sum-i);
                }
            }
        }

        Collections.sort(nums);
        return nums;
    }

    private boolean binarySearch(int[] array, int x) {

        int lo = 0, hi = array.length-1;


        while (lo <= hi) {

            int mid = (lo + hi) >> 1;

            if(array[mid] < x) {

                lo = mid + 1;

            } else if(array[mid] > x) {

                hi = mid - 1;

            } else {

                return true;
            }
        }

        return false;
    }
}
