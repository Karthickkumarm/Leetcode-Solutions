# https://leetcode.com/contest/weekly-contest-431/problems/maximum-subarray-with-equal-products/description/

from sys import maxsize

class Solution:
    def maxLength(self, nums: List[int]) -> int:
        n,ans=len(nums),0 
        for i in range(0,n,1):
            p,g,l=1,0,1
            for j in range(i,n,1):
                if p > (maxsize//nums[j]):
                    break
                p*=nums[j]
                g=nums[j] if j==i else gcd(g,nums[j])
                l=nums[j] if j==i else (l // gcd(l,nums[j]))*nums[j]
                if p==(g*l):
                    ans=max(ans,j-i+1)
        return ans
        