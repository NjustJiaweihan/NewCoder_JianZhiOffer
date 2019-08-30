public class Solution {

    int index = -1;
    
    //前序遍历
    String Serialize(TreeNode root) {

        StringBuilder s = new StringBuilder();

        if(root == null){
            return "#,";
        }

        s.append(root.val).append(",");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));

        return s.toString();
    }

    //反序列化
    TreeNode Deserialize(String str) {

        String[] seq = str.split(",");

        return Deserialize(seq);
    }

    private TreeNode Deserialize(String[] seq){

        index++;

        if(!seq[index].equals("#")){

            TreeNode leave = new TreeNode(Integer.parseInt(seq[index]));
            leave.left = Deserialize(seq);
            leave.right = Deserialize(seq);
            return leave;
        }
        return null;
    }
}
