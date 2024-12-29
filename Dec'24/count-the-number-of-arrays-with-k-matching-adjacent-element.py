# https://leetcode.com/contest/weekly-contest-430/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/

class Solution(object):
    def countGoodArrays(self, n, m, k):
        ans,b,exp,mod=1,m-1,n-k-1,int(1e9 +7)
        if k>=n: 
            return 0
        n1,d1=1,1 
        for i in range(0,k,1):
            n1=(n1*(n-1-i))%mod 
            d1=(d1*(i+1))%mod 
        t=(n1*pow(d1,mod-2,mod))%mod
        exp=pow(m-1,n-k-1,mod)
        ans=(t*m)%mod
        return (ans*exp)%mod