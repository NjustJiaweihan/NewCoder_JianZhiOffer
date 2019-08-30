public class Solution {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){

            return true;
        }

        return isSym(pRoot.left, pRoot.right);
    }

    //递归的比较其左右子结点值是否相等
    private boolean isSym(TreeNode leftTree, TreeNode rightTree){

        if(leftTree == null && rightTree == null){

            return true;
        }

        if(leftTree == null || rightTree == null){

            return false;
        }

        if(leftTree.val != rightTree.val){
            return false;
        }

        return isSym(leftTree.left, rightTree.right) && isSym(rightTree.left, leftTree.right);
    }
}
