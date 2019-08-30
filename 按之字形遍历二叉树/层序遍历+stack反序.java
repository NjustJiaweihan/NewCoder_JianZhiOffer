import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Stack<Integer> stack = new Stack<>();

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue1.add(pRoot);

        int layer = 1;

        while (!queue1.isEmpty() || !queue2.isEmpty()){

            if(layer % 2 != 0){

                ArrayList<Integer> list = new ArrayList<>();

                while (!queue1.isEmpty()){

                    TreeNode cur = queue1.poll();

                    if(cur != null){

                        queue2.add(cur.left);
                        queue2.add(cur.right);

                        list.add(cur.val);
                    }
                }

                if(!list.isEmpty()){

                    res.add(list);
                    layer++;
                }

            } else {

                ArrayList<Integer> list = new ArrayList<>();

                while (!queue2.isEmpty()){

                    TreeNode cur = queue2.poll();

                    if(cur != null){

                        queue1.add(cur.left);
                        queue1.add(cur.right);
                        //加一个stack反序偶数层顺序即可
                        stack.push(cur.val);
                    }
                }
                //将反序后的偶数层放入list
                while (!stack.isEmpty()){
                    list.add(stack.pop());
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
