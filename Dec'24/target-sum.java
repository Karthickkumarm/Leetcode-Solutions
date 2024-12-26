// https://leetcode.com/problems/target-sum/description/

class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int n : nums) {
            Map<Integer, Integer> dp1 = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                int key = e.getKey(), value = e.getValue();
                dp1.put(key + n, dp1.getOrDefault(key + n, 0) + value);
                dp1.put(key - n, dp1.getOrDefault(key - n, 0) + value);
            }
            dp = dp1;
        }
        return dp.getOrDefault(t, 0);
    }
}