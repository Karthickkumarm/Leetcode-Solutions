// https://leetcode.com/problems/count-ways-to-build-good-strings/ 

class Solution {
    public int countGoodStrings(int low, int h, int zero, int one) {
        int mod = 1000000007, ans = 0;
        int[] a = new int[h + 1];
        a[0] = 1;
        for (int i = 1; i <= h; i++) {
            if (i >= zero) {
                a[i] = (a[i] + a[i - zero]) % mod;
            }
            if (i >= one) {
                a[i] = (a[i] + a[i - one]) % mod;
            }
        }
        for (int i = low; i <= h; i++) {
            ans = (ans + a[i]) % mod;
        }
        return ans;

    }
}