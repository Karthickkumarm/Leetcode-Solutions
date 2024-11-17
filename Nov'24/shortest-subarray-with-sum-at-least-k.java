// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/ 

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        long c = 0;
        Deque<long[]> d = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            c += nums[i];
            if (k <= c) {
                ans = Math.min(i + 1, ans);
            }
            while (!d.isEmpty() && k <= (c - d.peekFirst()[0])) {
                ans = Math.min(i - (int) d.pollFirst()[1], ans);
            }
            while (!d.isEmpty() && d.peekLast()[0] >= c) {
                d.pollLast();
            }
            d.offerLast(new long[] { c, i });
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}