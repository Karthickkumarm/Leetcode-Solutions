# https://leetcode.com/problems/sliding-puzzle/description/ 

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        x,a,v=123450,[board[t//3][t%3] for t in range(6)],set() 
        q=deque([(0,a)])
        while q:
            s,a=q.popleft() 
            t=int(''.join(map(str,a)))
            if t==x:
                return s 
            if t in v:
                continue 
            v.add(t) 
            d,index=[-3,-1,3,1],a.index(0)
            for i in d:
                k=i+index 
                if (0<=k<6) and (index//3==k//3 or index%3==k%3):
                    a1=a[:]
                    a1[index],a1[k]=a1[k],a1[index] 
                    q.append((s+1,a1))
        return -1            
        