//https://leetcode.com/problems/count-the-number-of-fair-pairs/

class Solution {
    int bin(int a, int b, int x, int[] nums) {
        while (a <= b) {
            int m = (a + b) / 2;
            if (nums[m] >= x) {
                b = m - 1;
            } else {
                a = m + 1;
            }
        }
        return b;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = lower - nums[i], u = upper - nums[i];
            ans += (bin(i + 1, n - 1, u + 1, nums) - bin(i + 1, n - 1, l, nums));
        }
        return ans;
    }
}