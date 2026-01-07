/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long maxPro;
    double MOD = 1e9 + 7;

    long helper(TreeNode root) {
        if (root == null) return 0;
        return root.val + helper(root.left) + helper(root.right);
    }

    long maxSub(TreeNode root, long totalSum) {
        if (root == null) return 0;

        long subSum = root.val + maxSub(root.left, totalSum) + maxSub(root.right, totalSum);
        maxPro = Math.max(maxPro, (totalSum - subSum) * subSum);
        return subSum;
    }

    public int maxProduct(TreeNode root) {
        maxPro = 0;
        long totalSum = helper(root);
        maxSub(root, totalSum);
        return (int) (maxPro % MOD);
    }
}