// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/

class Solution {
    public int minimumTime(int[][] g) {
        int r = g.length, c = g[0].length;
        if (g[0][1] > 1 && g[1][0] > 1) {
            return -1;
        }
        int[][] m = new int[r][c];
        for (int[] k : m) {
            Arrays.fill(k, Integer.MAX_VALUE);
        }
        m[0][0] = 0;
        int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        p.offer(new int[] { 0, 0, 0 });
        while (!p.isEmpty()) {
            int[] cc1 = p.poll();
            int t = cc1[0], x = cc1[1], y = cc1[2];
            if (x == r - 1 && y == c - 1) {
                return t;
            }
            for (int[] d1 : d) {
                int i = x + d1[0], j = y + d1[1];
                if (i >= r || i < 0 || j < 0 || j >= c) {
                    continue;
                }
                int k = t + 1;
                if (k < g[i][j]) {
                    k += ((g[i][j] - k + 1) / 2) * 2;
                }
                if (m[i][j] > k) {
                    p.offer(new int[] { k, i, j });
                    m[i][j] = k;
                }
                // g[i][j]-=1;
            }
        }
        return -1;
    }
}