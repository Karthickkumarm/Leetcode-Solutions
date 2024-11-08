// https://leetcode.com/problems/maximum-xor-for-each-query/

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int x = 0, l = nums.length;
        int[] ans = new int[nums.length];
        for (int n : nums) {
            x ^= n;
        }
        int m = (1 << maximumBit) - 1;
        for (int i = l - 1; i >= 0; i--) {
            ans[l - i - 1] = x ^ m;
            x ^= nums[i];
        }
        return ans;

    }
}