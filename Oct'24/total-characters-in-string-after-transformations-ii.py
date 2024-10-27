# https://leetcode.com/contest/weekly-contest-421/problems/total-characters-in-string-after-transformations-ii/


m = 10**9 + 7
a = 26
class Solution:
    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        M = [[0] * a for _ in range(a)]
        for i in range(a):
            transforms = nums[i]
            for j in range(transforms):
                M[i][(i + j + 1) % a] += 1
        count = [0] * a
        for char in s:
            count[ord(char) - ord('a')] += 1
        def multiply(A, B):
            return [[sum(A[i][k] * B[k][j] for k in range(a)) % m for j in range(a)] for i in range(a)]
        def power(matrix, exp):
            result = [[1 if i == j else 0 for j in range(a)] for i in range(a)]
            while exp:
                if exp % 2:
                    result = multiply(result, matrix)
                matrix = multiply(matrix, matrix)
                exp //= 2
            return result
        M_t = power(M, t)
        final_count = [0] * a
        for i in range(a):
            for j in range(a):
                final_count[j] = (final_count[j] + M_t[i][j] * count[i]) % m
        return sum(final_count) % m