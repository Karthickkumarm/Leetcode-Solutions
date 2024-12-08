# https://leetcode.com/contest/biweekly-contest-145/problems/minimum-operations-to-make-array-values-equal-to-k/

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        m, ops, i = min(nums), 0, 0
        if nums[0] < k:
            return -1
        while i < len(nums):
            if nums[i] > k:
                ops += 1
                while (i + 1) < len(nums) and nums[i + 1] == nums[i]:
                    i += 1
            i += 1
        return ops