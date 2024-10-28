// https://leetcode.com/problems/longest-square-streak-in-an-array/description/ 

class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.sort(nums);
        int ans = -1;
        for (int n : nums) {
            int s = (int) Math.sqrt(n);
            if (s * s == n && m.containsKey(s)) {
                m.put(n, m.get(s) + 1);
                ans = Math.max(ans, m.get(n));
            } else {
                m.put(n, 1);
            }
        }
        return ans;
    }
}