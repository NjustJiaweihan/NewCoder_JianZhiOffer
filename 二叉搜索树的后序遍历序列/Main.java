//二叉搜索树：左子结点 < 根结点 < 右子结点
//后序遍历：5 8 7 | 11 13 12 | 9 根结点为9 左子树为5 8 7 右子树为 11 13 12
//后序遍历要合法 需要左子树都小于根结点 右子树都大于根结点 且左右子树也要合法

class Solution {

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence.length == 0) {

            return false;

        } else {

            return isBST(sequence, 0, sequence.length - 1);
        }
    }

    private boolean isBST(int[] seq, int start, int end) {

        if (start >= end) {

            return true;
        }

        //右子结点段首元素
        int index = start;
        
        //写成如下形式不妥：
        //例如：1，2，3，4，5   index=0 期望index=end=4
//        for (int i=start; i<end; i++) {
//            
//            if(seq[i] > seq[end]) {
//                
//                index = i;
//                break;
//            }
//        }
        
        while (seq[index] < seq[end]) {

            index++;
        }

        //右子结点段是否都大于根结点(数组末尾元素)
        for (int i = index; i < end; i++) {

            if (seq[i] < seq[end]) {

                return false;
            }
        }

        return isBST(seq, start, index - 1) && isBST(seq, index, end - 1);
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] seq = {1, 2, 3, 4, 5};
        System.out.println(solution.VerifySquenceOfBST(seq));
    }
}
