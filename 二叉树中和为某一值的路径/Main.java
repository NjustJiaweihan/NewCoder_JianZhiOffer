import java.util.ArrayList;

//前序遍历 
//主要问题是 new ArrayList<Integer>(path)

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {

        this.val = val;
    }

}

class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null || target < 0) {

            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> path = new ArrayList<>();

        allPaths(root, res, path, target);

        return res;

    }

    private void allPaths(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int target) {

        path.add(root.val);

        if (root.left == null && root.right == null) {

            if (root.val == target) {

                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);

            } else {

                path.remove(path.size() - 1);
            }

        } else {

            if (root.left != null) {

                allPaths(root.left, res, new ArrayList<Integer>(path), target - root.val);
            }

            if (root.right != null) {

                allPaths(root.right, res, new ArrayList<Integer>(path), target - root.val);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> res = solution.FindPath(root, 22);

        for (ArrayList a : res) {

            System.out.println(a);
        }
    }
}
