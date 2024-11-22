// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/description/ 

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        Map<String, Integer> m = new HashMap<>();
        for (int[] r : matrix) {
            StringBuilder a = new StringBuilder();
            int x = r[0];
            for (int n : r) {
                a.append(x == n ? 1 : 0);
            }
            String k = a.toString();
            m.put(k, m.getOrDefault(k, 0) + 1);
        }
        for (int x : m.values()) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}