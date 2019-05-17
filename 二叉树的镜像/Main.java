class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {

        this.val = val;

    }

}

class Solution {

    public void Mirror(TreeNode root) {

        if (root == null) {

            return;
        }

        exchange(root);

        Mirror(root.left);
        Mirror(root.right);

    }

    private void exchange(TreeNode root) {

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

public class Main {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        Solution solution = new Solution();
        solution.Mirror(root1);

        LDR(root1);

    }

    public static void LDR(TreeNode root) {

        if (root == null) {

            return;
        }

        LDR(root.left);
        System.out.println(root.val);
        LDR(root.right);

    }
}
