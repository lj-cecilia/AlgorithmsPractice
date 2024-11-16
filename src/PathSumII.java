//time O(nlogn), if there is a complete binary tree, then at the logn level leaf, need to do repeat peration for copyning logn size list n/2 times
//space O(n), add all nodes in the arraylist


import java.util.ArrayList;
import java.util.List;

class PathSumII {
//Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int currentSum, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) return;
        list.add(root.val);
        currentSum += root.val;
        if (currentSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        if (root.left != null) dfs(root.left, currentSum, targetSum, list, result);
        if (root.right != null) dfs(root.right, currentSum, targetSum, list, result);
        //current node is only added to paths for its subtree, not for parallel branches or branches above it
        list.remove(list.size() - 1);
    }
}