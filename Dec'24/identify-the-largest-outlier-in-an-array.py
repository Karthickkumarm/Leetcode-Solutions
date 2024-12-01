# https://leetcode.com/contest/weekly-contest-426/problems/identify-the-largest-outlier-in-an-array/description/

class Solution:
    def getLargestOutlier(self, nums: List[int]) -> int:
        s,c,ans=sum(nums),Counter(nums),float('-inf')
        for i in nums:
            if (s-i)%2==0:
                c[i]-=1
                if c[i]==0:
                    del c[i]
                t=(s-i)//2
                if t in c:
                    ans=max(i,ans)
                c[i]+=1    
        if ans==float('-inf'):
            return -1
        return ans
        