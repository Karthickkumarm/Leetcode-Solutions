// https://leetcode.com/problems/maximum-matrix-sum/description/ 

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0, n = 0, m = Long.MAX_VALUE;
        for (int[] r : matrix) {
            for (int x : r) {
                if (x < 0) {
                    n += 1;
                }
                ans += Math.abs(x);
                m = Math.min(Math.abs(x), m);
            }
        }
        if ((n & 1) != 0) {
            ans -= 2 * m;
        }
        return ans;

    }
}