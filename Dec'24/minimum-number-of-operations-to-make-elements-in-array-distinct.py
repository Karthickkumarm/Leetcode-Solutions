# https://leetcode.com/contest/weekly-contest-429/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/

class Solution(object):
    def minimumOperations(self, nums):
        ans,f,i=0,set(),len(nums)-1
        while i>=0:
            if nums[i] in f:
                ans=i+1 
                break 
            f.add(nums[i])
            i-=1
        if ans%3!=0 :
            ans=ans//3 +1
        else:
            ans=ans//3 
        return ans
        