class Solution{
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if(array == null || array.length == 1) {

            return;
        }

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for(int i : array) {

            if(hashtable.isEmpty()) {

                hashtable.put(i, i);
            } else if(hashtable.contains(i)){

                hashtable.remove(i);
            } else {

                hashtable.put(i, i);
            }
        }

        int[] a = new int[2];
        int j=0;
        for(Integer i : hashtable.values()) {

            a[j] = i;
            j++;
        }

        num1[0] = a[0];
        num2[0] = a[1];
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] arr = {1,2,3,3,4,4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + num2[0]);
    }
}
