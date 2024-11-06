// https://leetcode.com/problems/find-if-array-can-be-sorted/description/

class Solution {
    public boolean canSortArray(int[] nums) {
        int c1 = nums[0], c2 = nums[0], prev = Integer.MIN_VALUE;
        for (int n : nums) {
            if (count(n) == count(c1)) {
                c1 = Math.min(n, c1);
                c2 = Math.max(n, c2);
            } else {
                if (c1 < prev) {
                    return false;
                }
                prev = c2;
                c1 = n;
                c2 = n;
            }
        }
        return !(c1 < prev);
    }

    private int count(int x) {
        return Integer.bitCount(x);
    }
}