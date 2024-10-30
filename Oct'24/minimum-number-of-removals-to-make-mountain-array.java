// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/ 

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int ans = n;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                ans = Math.min(ans, n - lis[i] - lds[i] + 1);
            }
        }

        return ans;
    }
}
