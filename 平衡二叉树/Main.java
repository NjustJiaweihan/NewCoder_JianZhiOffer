public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        
        return IsBalanced(root) != -1;
    }
    
    private int IsBalanced(TreeNode root){
        
        if(root == null) {
            
            return 0;
        }
        
        int left = IsBalanced(root.left);
        
        if(left == -1){
            
            return -1;
        }
        
        int right = IsBalanced(root.right);
        
        if(right == -1){
            
            return -1;
        }
        
        return Math.abs(left-right) > 1 ? -1 : 1+Math.max(right,left);
    }
}
