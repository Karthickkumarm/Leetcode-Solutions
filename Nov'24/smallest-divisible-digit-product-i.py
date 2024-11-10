# https://leetcode.com/contest/biweekly-contest-143/problems/smallest-divisible-digit-product-i/description/ 

class Solution(object):
    def smallestNumber(self, n, t):
        while True:
            k=1
            for i in str(n):
                k*=int(i)
            if k%t==0:
                return n
            n+=1    
        