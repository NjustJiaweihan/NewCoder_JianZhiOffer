import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

class Solution {

    private int min = 0;
    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {

        if (stack.isEmpty() || node < min) {

            min = node;
        }

        stack.push(node);
    }

    public void pop() {

        if (stack.peek() == min) {

            stack.pop();
            //new ArrayList<>(Collection c)的用处
            //ArrayList.addAll(stack)的用处
            ArrayList<Integer> findMin = new ArrayList<>(stack);

            Collections.sort(findMin);

            min = findMin.get(0);

        } else {

            stack.pop();
        }

    }

    public int top() {

        return stack.peek();

    }

    public int min() {

        return min;

    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.push(3);
        System.out.println(solution.min());
        solution.push(4);
        System.out.println(solution.min());
        solution.push(2);
        System.out.println(solution.min());
        solution.push(3);
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.push(0);
        System.out.println(solution.min());
    }
}
