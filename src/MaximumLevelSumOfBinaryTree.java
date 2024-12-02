//time O(n)
//space O(n)

import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class MaximumLevelSumOfBinaryTree {
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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int result = 0;
        int index = 1;
        q.add(root);
        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            levels.add(sum);
        }
        while (!levels.isEmpty()) {
            int level = levels.remove();
            if (level > max) {
                result = index;
                max = level;
            }
            index++;
        }
        return result;
    }
}