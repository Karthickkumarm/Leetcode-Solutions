// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/ 

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0, s = 0;
        int i = 0, j = 0, t = 0;
        Map<Integer, Integer> a = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            s += nums[i];
            if (a.containsKey(nums[i])) {
                t = a.get(nums[i]);
            } else {
                t = -1;
            }
            while ((j <= t) || (i - j + 1 > k)) {
                s -= nums[j++];
            }
            if (i - j + 1 == k) {
                ans = Math.max(ans, s);
            }
            a.put(nums[i], i);
        }
        return ans;
    }
}