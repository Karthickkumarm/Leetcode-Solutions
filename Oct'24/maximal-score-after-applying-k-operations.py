# https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/
# Input: nums = [10,10,10,10,10], k = 5
# Output: 50
#Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

def maxKelements(self, nums, k):
    ans=0
    h=[-n for n in nums]
    heapq.heapify(h)
    while k:
        n=-heapq.heappop(h)
        ans+=n
        heapq.heappush(h,-((n+2)/3))
        k-=1
    return ans