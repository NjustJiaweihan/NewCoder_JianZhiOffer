import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (input == null || input.length == 0 || k > input.length) {

            return new ArrayList<>();
        }

        Arrays.sort(input);

        ArrayList<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {

            res.add(input[i]);
        }

        return res;
    }
}
