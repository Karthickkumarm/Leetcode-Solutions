// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        while (!q.isEmpty()) {
            long levelSum = 0;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            minHeap.offer(levelSum);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.size() < k ? -1 : minHeap.peek();
    }
}