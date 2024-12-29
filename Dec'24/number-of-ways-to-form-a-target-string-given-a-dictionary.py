# https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/

class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        wn,tn=len(words[0]),len(target)
        if tn>wn:
            return 0 
        c,m,ans=[defaultdict(int) for i in range(wn)],10**9 +7,[0]*(tn+1)
        ans[0]=1 
        for w in words:
            for i,cc in enumerate(w):
                c[i][cc]+=1 
        for i in range(0,wn,1):
            for j in range(tn-1,-1,-1):
                ans[j+1]=(ans[j+1]+ans[j]*c[i][target[j]])%m 
        return ans[tn]