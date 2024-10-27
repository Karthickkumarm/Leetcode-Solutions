# https://leetcode.com/contest/weekly-contest-421/problems/find-the-maximum-factor-score-of-array/ 

class Solution:
    def maxScore(self, nums: List[int]) -> int:
        ans=gcd(*nums)*lcm(*nums)
        for i in range(len(nums)):
            s=nums[:i]+nums[i+1:]
            ans=max(ans,gcd(*s)*lcm(*s))
        return ans
        