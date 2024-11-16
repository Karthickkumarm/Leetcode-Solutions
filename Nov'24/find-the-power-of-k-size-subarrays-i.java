// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/ 

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length,c=1;
        int[] a=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(i<n-k+1){
                a[i]=-1;
            }
            if(i>0 && nums[i]==(nums[i-1]+1)){
                c+=1;
            }else{
                c=1;
            }
            if(k<=c){
                a[i-k+1]=nums[i];
            }
        }
        return a;
        
    }
}