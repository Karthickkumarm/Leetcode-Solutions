# https://leetcode.com/contest/weekly-contest-421/problems/total-characters-in-string-after-transformations-i/ 

class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        m, l = 10**9 + 7, [0] * 26
        for char in s:
            l[ord(char) - ord("a")] += 1
        for i in range(t):
            u = [0] * 26
            for i in range(26):
                if i == 25:
                    u[0] = (u[0] + l[i]) % m
                    u[1] = (u[1] + l[i]) % m
                else:
                    u[i + 1] = (u[i + 1] + l[i]) % m
            l = u
        return sum(l) % m
