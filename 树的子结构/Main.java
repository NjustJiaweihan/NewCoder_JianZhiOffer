// 第一步在树A中找到和B的根节点的值一样的结点R，
// 第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构。

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {

        this.val = val;

    }

}

class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        //空树不是任何树的子结构
        if (root1 == null || root2 == null) {

            return false;
        }

        if (root1.val == root2.val) {

            if (contains(root1.left, root2.left) && contains(root1.right, root2.right)) {

                return true;
            }
        }

        //遍历A树 找到与B树根结点相同的结点
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean contains(TreeNode t1, TreeNode t2) {

        //B树遍历检查结束 依然没有不同 返回true
        if (t2 == null) {

            return true;
        }

        //B树没有结束 A树结束了 返回false
        if (t1 == null) {

            return false;
        }

        if (t1.val == t2.val) {

            return contains(t1.left, t2.left) && contains(t1.right, t2.right);
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.HasSubtree(root1, null));

    }
}
