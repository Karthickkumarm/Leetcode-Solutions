// https://leetcode.com/problems/number-of-ways-to-split-array/description/

class Solution {
    public int waysToSplitArray(int[] nums) {
        long p = 0, s = 0;
        int ans = 0;
        for (int x : nums) {
            s += x;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i];
            p += x;
            s -= x;
            if (p >= s) {
                ans += 1;
            }
        }
        return ans;
    }
}