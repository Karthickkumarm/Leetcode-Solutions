# https://leetcode.com/problems/super-pow/

class Solution(object):
    def superPow(self, a, b):
        if a==1:
            return a 
        n=(int)("".join(map(str,b)))
        def pow(x, n):
            if n == 0:
                return 1
            elif n%2==0:
                res =  pow(x, n>>1)%1337
                return res**2
            else:
                res = pow(x, (n-1)>>1)%1337
                return x*(res**2)
            
        return pow(a, n)%1337
        