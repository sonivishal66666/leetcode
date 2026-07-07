1class Solution {
2    public boolean hasPathSum(TreeNode root, int targetSum) {
3        if (root == null)
4            return false;
5
6        if (root.left == null && root.right == null)
7            return targetSum == root.val;
8
9        return hasPathSum(root.left, targetSum - root.val) ||
10               hasPathSum(root.right, targetSum - root.val);
11    }
12}