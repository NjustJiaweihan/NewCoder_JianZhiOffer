class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int val) {

        this.val = val;
    }
}

class Solution {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) throws Exception {

        if(pre == null || pre.length==0 || in==null || in.length==0) {

            return null;
        }

        return constract(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode constract(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) throws Exception {

        if(preStart > preEnd || inStart > inEnd)
        {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);

        int rootIndex = 0;
        for(int i=0; i<in.length; i++)
        {
            if(in[i] == pre[preStart]) {

                rootIndex = i;
            }
        }

        root.left = constract(pre, preStart+1, preStart+rootIndex-inStart, in, inStart, rootIndex-1);

        root.right = constract(pre, rootIndex+1-inStart+preStart, preEnd, in, rootIndex+1, inEnd);

        return root;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        DLR(solution.reConstructBinaryTree(pre, in));
    }

    public static void DLR(TreeNode root)
    {
        if(root != null)
        {
            System.out.print(root.val + " ");
            DLR(root.left);
            DLR(root.right);
        }
    }
}
