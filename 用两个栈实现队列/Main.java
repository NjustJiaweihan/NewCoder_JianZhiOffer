import java.util.Stack;

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);

        if(stack2.isEmpty()) {

            pushAll();
        }
    }

    public int pop() {

        if(stack2.isEmpty()) {

            return -1;
        }

        int res = stack2.pop();

        if(stack2.isEmpty()) {

            pushAll();
        }

        return res;
    }

    private void pushAll() {

        while (!stack1.isEmpty()) {

            stack2.push(stack1.pop());
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.push(5);

        for(int i=0; i<5; ++i) {

            System.out.print(solution.pop() + " ");
        }
    }
}
