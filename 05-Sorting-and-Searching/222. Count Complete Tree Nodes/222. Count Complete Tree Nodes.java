1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int countNodes(TreeNode root) {
18        if (root == null) return 0;
19
20        int leftHeight = leftHeight(root);
21        int rightHeight = rightHeight(root);
22
23        if (leftHeight == rightHeight) {
24            return (1 << leftHeight) - 1;
25        }
26
27        return 1 + countNodes(root.left) + countNodes(root.right);
28    }
29
30    private int leftHeight(TreeNode node) {
31        int h = 0;
32        while (node != null) {
33            h++;
34            node = node.left;
35        }
36        return h;
37    }
38
39    private int rightHeight(TreeNode node) {
40        int h = 0;
41        while (node != null) {
42            h++;
43            node = node.right;
44        }
45        return h;
46    }
47}