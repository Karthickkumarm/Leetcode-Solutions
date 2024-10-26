// https://leetcode.com/contest/biweekly-contest-142/problems/maximum-points-tourist-can-earn/

class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] dp = new int[k][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, tour(0, i, k, n, dp, stayScore, travelScore));
        }
        return ans;
    }
    public int tour(int day, int city, int k, int n, int[][] dp, int[][] stayScore, int[][] travelScore) {
        if (day == k) {
            return 0;
        }
        if (dp[day][city] != -1) {
            return dp[day][city];
        }
        int s = stayScore[day][city] + tour(day + 1, city, k, n, dp, stayScore, travelScore);
        for (int j = 0; j < n; j++) {
            if (j != city) {
                s = Math.max(s, travelScore[city][j] + tour(day + 1, j, k, n, dp, stayScore, travelScore));
            }
        }
        dp[day][city] = s;
        return dp[day][city];
    }
}