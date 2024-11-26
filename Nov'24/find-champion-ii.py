# https://leetcode.com/problems/find-champion-ii/description/ 

class Solution(object):
    def findChampion(self, n, edges):
        a,ans=[0]*n,-1
        for k in edges:
            a[k[1]]+=1 
        for i in range(0,n,1):
            if a[i]==0:
                if ans!=-1:
                    return -1 
                ans=i 
        return ans