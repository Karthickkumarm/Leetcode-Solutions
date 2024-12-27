// https://leetcode.com/problems/best-sightseeing-pair/description/

class Solution {
    public int maxScoreSightseeingPair(int[] v) {
        int ans = 0, left = v[0];
        for (int i = 1; i < v.length; i++) {
            int current = left + (v[i] - i);
            left = Math.max(left, v[i] + i);
            ans = Math.max(ans, current);
        }
        return ans;
    }
}