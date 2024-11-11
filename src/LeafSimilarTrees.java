//time O(n + m)
//space O(n + m)
//each node is visited exactly once, n and m is the number of nodes in tree1 and tree2
//the max number of leaves is n/2 and m/2 and combine to get n + m
import java.util.ArrayList;
import java.util.List;

//notice need to store integer values in the list not the node
//the list return true only if the node reference to the exact same node
class LeafSimilarTrees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}