import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int layer = 1;

        queue1.add(pRoot);

        while (!queue1.isEmpty() || !queue2.isEmpty()){

            if(layer % 2 != 0){

                ArrayList<Integer> list = new ArrayList<>();

                while (!queue1.isEmpty()){

                    TreeNode cur = queue1.poll();

                    if(cur != null){

                        queue2.add(cur.left);
                        queue2.add(cur.right);

                        list.add(cur.val);
                    }
                }

                if(!list.isEmpty()){

                    res.add(list);
                    layer++;
                }
            } else {

                ArrayList<Integer> list = new ArrayList<>();

                while (!queue2.isEmpty()){

                    TreeNode cur = queue2.poll();

                    if(cur != null){

                        queue1.add(cur.left);
                        queue1.add(cur.right);

                        list.add(cur.val);
                    }
                }

                if(!list.isEmpty()){

                    res.add(list);
                    layer++;
                }
            }

        }
        return res;
    }
}
