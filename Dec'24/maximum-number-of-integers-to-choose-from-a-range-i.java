//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/

class Solution {
    public int maxCount(int[] b, int n, int m) {
        int[] a =new int[n];
        int ans=0,s=0;
        for(int i=1;i<=n;i++){
            a[i-1]=i;
        }
        for(int i=0;i<b.length;i++){
            if(b[i]<=n){
                a[b[i]-1]=0;
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]!=0){
                s+=a[i];
                if(s<=m){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}