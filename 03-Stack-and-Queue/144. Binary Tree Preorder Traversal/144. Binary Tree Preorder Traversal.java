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
17    public List<Integer> preorderTraversal(TreeNode root) {
18        List<Integer> result = new ArrayList<>();
19        preorder(root, result);
20        return result;
21    }
22
23    private void preorder(TreeNode node, List<Integer> result) {
24        if (node == null) return;
25
26        result.add(node.val);
27        preorder(node.left, result);
28        preorder(node.right, result);
29    }
30}