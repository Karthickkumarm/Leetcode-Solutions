// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[3];
        int kn = n - k + 1, ln = n - 3 * k + 1;
        int s1[] = new int[kn];
        int s2[] = new int[ln];
        int s3[] = new int[ln];
        Arrays.fill(s2, -1);
        Arrays.fill(s3, -1);
        Arrays.fill(ans, -1);
        for (int i = 0; i < k; i++) {
            s1[0] += nums[i];
        }
        int m = s1[0], m1 = 0;
        s2[0] = 0;
        for (int i = 1; i <= n - k; i++) {
            s1[i] = s1[i - 1] - nums[i - 1] + nums[i + k - 1];
            if (i > (ln - 1)) {
                continue;
            }
            if (m < s1[i]) {
                m = s1[i];
                s2[i] = i;
            } else {
                s2[i] = s2[i - 1];
            }
        }
        m = s1[n - k];
        s3[n - 3 * k] = n - k;
        for (int i = n - k - 1; i >= 2 * k; i -= 1) {
            int t = i - 2 * k;
            if (m <= s1[i]) {
                m = s1[i];
                s3[t] = i;
            } else {
                s3[t] = s3[t + 1];
            }
        }
        for (int i = 0; i <= (ln - 1); i++) {
            int t = s1[s2[i]] + s1[i + k] + s1[s3[i]];
            if (t > m1) {
                m1 = t;
                ans[0] = s2[i];
                ans[1] = i + k;
                ans[2] = s3[i];
            }
        }
        return ans;
    }
}