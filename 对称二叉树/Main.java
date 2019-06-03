class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution {

    public boolean isSymmetrical(TreeNode pRoot) {

        if(pRoot == null) {

            return true;

        } else {

            return isSymmetrical(pRoot, pRoot);
        }
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {

            return true;
        }

        if(root1 == null || root2 == null) {

            return false;
        }

        if(root1.val == root2.val) {

            return isSymmetrical(root1.left, root2.right);
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        System.out.println(solution.isSymmetrical(root));
    }
}
