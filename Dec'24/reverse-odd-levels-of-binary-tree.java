// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 1);
        return root;
    }

    public void reverse(TreeNode l, TreeNode r, int index) {
        if (l == null || r == null) {
            return;
        }
        if (index % 2 == 1) {
            int t = l.val;
            l.val = r.val;
            r.val = t;
        }
        reverse(l.right, r.left, index + 1);
        reverse(l.left, r.right, index + 1);
    }
}