// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/ 

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] w) {
        int[][] g = new int[m][n];
        int ans = 0;
        for (int i = 0; i < guards.length; i++) {
            g[guards[i][0]][guards[i][1]] = 1;
        }
        for (int i = 0; i < w.length; i++) {
            g[w[i][0]][w[i][1]] = 1;
        }
        for (int t = 0; t < guards.length; t++) {
            int r = guards[t][0], c = guards[t][1];
            for (int i = r + 1; i < m; i++) {
                if (g[i][c] == 1 || g[i][c] == 2) {
                    break;
                }
                g[i][c] = 3;
            }
            for (int i = r - 1; i >= 0; i--) {
                if (g[i][c] == 1 || g[i][c] == 2) {
                    break;
                }
                g[i][c] = 3;
            }
            for (int i = c + 1; i < n; i++) {
                if (g[r][i] == 1 || g[r][i] == 2) {
                    break;
                }
                g[r][i] = 3;
            }
            for (int i = c - 1; i >= 0; i--) {
                if (g[r][i] == 1 || g[r][i] == 2) {
                    break;
                }
                g[r][i] = 3;
            }
        }
        for (int[] a : g) {
            for (int x : a) {
                if (x == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}