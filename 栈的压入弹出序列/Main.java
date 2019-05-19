import java.util.Stack;

//要弹出的数m不在栈顶那就去pushA中不断压栈 直到peek()==m
//要是pushA压空了也没有peek()==m 
//那就说明m在栈里且非栈顶 return false

class Solution {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();

        int indexPush = -1;
        int indexPop = 0;

        while (indexPop < popA.length) {

            if (stack.isEmpty() || popA[indexPop] != stack.peek()) {

                indexPush++;

                //pushA找穿
                if (indexPush >= pushA.length) {

                    return false;
                }

                stack.push(pushA[indexPush]);

            } else {

                indexPop++;
                stack.pop();
            }
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(solution.IsPopOrder(pushA, popA));
    }
}
