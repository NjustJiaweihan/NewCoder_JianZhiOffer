// 一个数与该数减一的结果进行与运算，会把该数右边（低位）第一个1变为0，而该位左边保持不变（高位）。
// 可以举一个简单的例子进行证明：比如1100（对应十进制是12），减去1之后的结果是1011（也就是十进制的11），
// 两个数进行与运算之后，我们发现最后的结果是1000（对应十进制的8，当然这个8与后面没有关系，可以略过）。
// 这样我们每进行一次的与运算就消去一个1，这样消到最后肯定是0了，所以我们可以在代码中以这个为循环的终止条件。

class Solution {

    public int NumberOf1(int n) {

        int cnt = 0;

        while (n != 0) {

            n &= n-1;
            cnt++;
        }
        return cnt;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.NumberOf1(0));

    }
}
