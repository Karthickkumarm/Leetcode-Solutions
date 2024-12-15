# https://leetcode.com/contest/weekly-contest-428/problems/button-with-longest-push-time/description/ 

class Solution:
    def buttonWithLongestTime(self, events: List[List[int]]) -> int:
        lt,lb=events[0][1],events[0][0]
        for i in range(1,len(events),1):
            t=events[i][1]-events[i-1][1] 
            if (t== lt and events[i][0]<lb) or t >lt :
                lt,lb=t,events[i][0] 
        return lb
        