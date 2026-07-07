1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        return height(root) != -1;
4    }
5
6    private int height(TreeNode node) {
7        if (node == null)
8            return 0;
9
10        int left = height(node.left);
11        if (left == -1)
12            return -1;
13
14        int right = height(node.right);
15        if (right == -1)
16            return -1;
17
18        if (Math.abs(left - right) > 1)
19            return -1;
20
21        return 1 + Math.max(left, right);
22    }
23}