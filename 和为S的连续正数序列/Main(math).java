//我自己也没研究 贴一个参考阅读吧
//https://blog.csdn.net/qq_41822235/article/details/82109081

import java.util.ArrayList;
class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer> > allRes = new ArrayList<>();
        for (int n = (int)Math.sqrt(2 * sum); n >= 2; --n) {
            if (((n & 1) == 1 && sum % n == 0) || (sum % n * 2 == n)){
                ArrayList<Integer> res = new ArrayList<>();
                //j用于计数，k用于遍历求值
                for(int j = 0,k = sum / n - (n - 1) / 2; j < n; j++, k++)
                    res.add(k);
                allRes.add(res);
            }
        }
        return allRes;
    }
}
