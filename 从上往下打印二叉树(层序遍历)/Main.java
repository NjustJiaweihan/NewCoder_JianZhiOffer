import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {

        this.val = val;

    }
}

class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if (root == null) {

            //做题一般不返回null
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        //TODO 复习bfs + util中的queue实现

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        TreeNode cur = null;

        while (!queue.isEmpty()) {

            cur = queue.peek();

            res.add(cur.val);

            if (cur.left != null) {

                queue.add(cur.left);
            }

            if (cur.right != null) {

                queue.add(cur.right);
            }

            queue.poll();
        }

        return res;

    }
}
