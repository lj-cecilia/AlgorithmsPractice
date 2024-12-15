////time O(n)
////space O(n)
////visit every node once for n and space n for the call stack of linkedlist like treepublic class longestZigZagInBinaryTree {
//     public class TreeNode {
//         int val;TreeNode left;
//         TreeNode right;
//         TreeNode() {};
//         TreeNode(int val) {
//             this.val = val;
//         }
//         TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }
//     int max = 0;
//     public int longestZigZag(TreeNode root) {
//         if (root == null) return 0;
//         dfs(root.left, 1, true);
//         dfs(root.right, 1, false);
//         return max;
//     }
//
//     public void dfs(TreeNode root, int steps, boolean isLeft) {
//         if (root == null) return;
//         max = Math.max(max, steps);
//         if (isLeft) {
//             dfs(root.left, 1, true);
//             dfs(root.right, steps + 1, false);
//         }
//         else {
//             dfs(root.left, steps + 1, true);
//             dfs(root.right, 1, false);
//         }
//     }
//}
//
////abbreviated version with one recursive call from the parent function
////class Solution {
////    int max = 0;
////    public int longestZigZag(TreeNode root) {
////        boolean isLeft = false;
////        dfs(root, isLeft, 0);
////        return max;
////    }
////
////    public void dfs(TreeNode root, boolean isLeft, int current) {
////        if (root == null) return;
////        max = Math.max(max, current);
////        if (isLeft) {
////            dfs(root.left, true, 1);
////            dfs(root.right, false, current + 1);
////        }
////        else {
////            dfs(root.left, true, current + 1);
////            dfs(root.right, false, 1);
////        }
////    }
////}
