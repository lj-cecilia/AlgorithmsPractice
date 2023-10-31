public class longestZigZagInBinaryTree {
     public class TreeNode {
         int val;TreeNode left;
         TreeNode right;
         TreeNode() {};
         TreeNode(int val) {
             this.val = val;
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     int max = 0;
     public int longestZigZag(TreeNode root) {
         if (root == null) return 0;
         dfs(root.left, 1, true);
         dfs(root.right, 1, false);
         return max;
     }

     public void dfs(TreeNode root, int steps, boolean isLeft) {
         if (root == null) return;
         max = Math.max(max, steps);
         if (isLeft) {
             dfs(root.left, 1, true);
             dfs(root.right, steps + 1, false);
         }
         else {
             dfs(root.left, steps + 1, true);
             dfs(root.right, 1, false);
         }
     }
}
