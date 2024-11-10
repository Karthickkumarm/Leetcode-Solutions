// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, ans = nums.length + 1, i = 0, l = 0, r = 0;
        for (r = 0; r < n; r++) {
            i |= nums[r];
            if (i >= k) {
                l = r;
                i = nums[r];
                int p = 0;
                while (i < k) {
                    p = i;
                    i |= nums[--l];
                }
                i = p;
                ans = Math.min(r - l + 1, ans);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}