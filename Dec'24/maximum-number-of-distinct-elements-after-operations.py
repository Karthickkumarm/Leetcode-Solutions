# https://leetcode.com/contest/weekly-contest-429/problems/maximum-number-of-distinct-elements-after-operations/

class Solution(object):
    def maxDistinctElements(self, nums, key):
        if not nums:
            return 0 
        nums.sort()
        f,ans,k=set(),0,float('-inf')
        for i in nums:
            t=max(k,i-key)
            if t<=i+key:
                f.add(t)
                k=t+1
            ans=len(f)
        return ans