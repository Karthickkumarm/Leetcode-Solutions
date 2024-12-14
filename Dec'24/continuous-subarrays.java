// https://leetcode.com/problems/continuous-subarrays/description/

class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> m1=new ArrayDeque<>();
        Deque<Integer> m2=new ArrayDeque<>();
        long ans=0;
        int n=nums.length,l=0,r=0;
        for(r=0;r<n;r++){
            while(!m2.isEmpty() && m2.peekLast() <nums[r]){
                m2.pollLast();
            }
            m2.offerLast(nums[r]);
            while(!m1.isEmpty() && m1.peekLast() > nums[r]){
                m1.pollLast();
            }
            m1.offerLast(nums[r]);
            while((m2.peekFirst() - m1.peekFirst()) >2){
                if(m1.peekFirst()==nums[l]){
                    m1.pollFirst();
                }
                if(m2.peekFirst()==nums[l]){
                    m2.pollFirst();
                }
                l+=1;
            }
            ans+=(r-l)+1;
        }
        return ans;
    }
}