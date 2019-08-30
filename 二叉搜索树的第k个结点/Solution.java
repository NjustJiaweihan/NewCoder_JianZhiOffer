import java.util.ArrayList;

public class 二叉搜索树的第k个结点 {

    int cnt = 0;
    int K;
    TreeNode node = null;

    //中序遍历的第k个结点
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        this.K = k;
        LDR(pRoot);
        return node;
    }

    private void LDR(TreeNode root){

        if(root != null){

            LDR(root.left);

            cnt++;
            if(cnt == K){
                node = root;
                return;
            }

            LDR(root.right);
        }
    }
}
