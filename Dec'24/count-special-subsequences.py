# https://leetcode.com/contest/weekly-contest-430/problems/count-special-subsequences/

class Solution(object):
    def numberOfSubsequences(self, nums):
        n,ans,p=len(nums),0,defaultdict(lambda : defaultdict(int))
        for n1 in range(0,n,1):
            for n2 in range(0,n1-1,1):
                ans+=p[nums[n2]*nums[n1]][n2]
            for n2 in range(0,n1-1,1):
                p[nums[n2]*nums[n1]][n1]+=1 
        return ans