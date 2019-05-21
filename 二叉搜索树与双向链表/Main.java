class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {

        this.val = val;
    }

}

class Solution {

    private TreeNode cur;
    private TreeNode head;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {

            return null;
        }

        //中序遍历 就是生序
        
        Convert(pRootOfTree.left);
        
        //此时head记录下了二叉树最左结点 就是双向链表的头结点
        if (cur == null) {

            cur = head = pRootOfTree;
            
        } else {

            //pRootOfTree左子树转换完成 cur指向左子树双向链表尾结点
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
            //完成转换 cur后移
            cur = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return head;
    }
}

public class Main {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.left = node5;

        //测试用例中序遍历序列：null 1 null 2 null 3 null 4 null 5 null
        Solution solution = new Solution();
        TreeNode head = solution.Convert(node1);

        System.out.print(head.val + "->");
        System.out.print(head.right.val + "->");
        System.out.print(head.right.right.val);
    }
}
