# https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/

class Solution(object):
    def findScore(self, nums):
        i,ans=0,0
        while i<len(nums):
            k=i 
            while(i+1 < len(nums) and nums[i+1]<nums[i]):
                i+=1 
            for j in range(i,k-1,-2):
                ans+=nums[j]
            i+=2    
        return ans
        