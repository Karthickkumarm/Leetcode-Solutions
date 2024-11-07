//https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/?envType=daily-question&envId=2024-11-07

class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int k = 0; k < 24; k++) {
            int c = 0;
            for (int n : candidates) {
                c += ((n & (1 << k)) != 0) ? 1 : 0;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}