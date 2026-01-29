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
    Map<String, Integer> count = new HashMap<String, Integer>();
    int maxCount = 0;
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) return "";
        String sb = dfs(root.left) + ">" + dfs(root.right) + ">" + root.val;
        count.put(sb, count.getOrDefault(sb, 0) + 1);
        if (count.get(sb) == 2) res.add(root);
        return sb;
    }
}