# https://leetcode.com/problems/two-best-non-overlapping-events/description/

class Solution(object):
    def maxTwoEvents(self, e):
        e.sort()
        s,ans,n=[],0,len(e)
        for i in range(n-1,-1,-1):
            k=e[i]
            if not s or s[-1][1]<k[2]:
                s.append((k[0],k[2]))
            ans=max(ans,k[2])
        e.sort(key=lambda t:t[1])
        for i in e:
            while s and s[-1][0] <= i[1]:
                s.pop()
            if s:
                ans=max(s[-1][1]+i[2],ans)
        return ans             

