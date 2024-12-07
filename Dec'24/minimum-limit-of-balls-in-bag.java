// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/

class Solution {
    public int minimumSize(int[] n, int maxOperations) {
        int l=1,h=0;
        for(int x:n){
            h=Math.max(x,h);
        }
        while(l<h){
            int m=l+(h-l)/2,t=0;
            for(int x:n){
                t+=(x-1)/m;
                if(t>maxOperations){
                    break;
                }
            }
            if(t<=maxOperations){
                    h=m;
                }else{
                    l=m+1;
                }
        }
        return h;
    }
}