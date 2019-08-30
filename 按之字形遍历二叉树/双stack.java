import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        stack1.add(pRoot);

        int layer = 1;

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            if(layer % 2 != 0){

                ArrayList<Integer> list = new ArrayList<>();

                while (!stack1.isEmpty()){

                    TreeNode cur = stack1.pop();

                    if(cur != null){

                        stack2.add(cur.left);
                        stack2.add(cur.right);

                        list.add(cur.val);
                    }
                }

                if(!list.isEmpty()){

                    res.add(list);
                    layer++;
                }

            } else {

                ArrayList<Integer> list = new ArrayList<>();

                while (!stack2.isEmpty()){

                    TreeNode cur = stack2.pop();

                    if(cur != null){

                        stack1.add(cur.right);
                        stack1.add(cur.left);

                        list.add(cur.val);
                    }
                }

                if(!list.isEmpty()){

                    res.add(list);
                    layer++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        //{8,6,10,5,7,9,11}
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        ArrayList res = new 之字形顺序打印二叉树().Print(root);

        System.out.println(res);

    }
}
