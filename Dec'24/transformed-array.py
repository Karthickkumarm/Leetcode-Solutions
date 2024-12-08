# https://leetcode.com/contest/weekly-contest-427/problems/transformed-array/description/

class Solution(object):
    def constructTransformedArray(self, a):
        n,ans=len(a),[0]*len(a)
        for i in range(0,n,1):
            if a[i]<0:
                t=(i+a[i])%n 
                if t<0:
                    t+=n 
                ans[i]=a[t] 
            elif a[i]>0:
                ans[i]=a[(i+a[i])%n]
            else:
                ans[i]=a[i]
        return ans