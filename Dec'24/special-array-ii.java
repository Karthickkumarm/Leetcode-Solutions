// https://leetcode.com/problems/special-array-ii/description/ 

class Solution {
    public boolean[] isArraySpecial(int[] n, int[][] q) {
        int l1=n.length-1,l2=q.length,k=0;
        for(int i=0;i<=l1;i++){
            k=(i>k) ? i : k;
            while(k<l1 && n[k]%2!=n[k+1]%2){
                k+=1;
            }
            n[i]=k;
        }
        boolean[] ans=new boolean[l2];
        int i=0;
        for(int[] t:q){
            ans[i++]=(t[1]<=n[t[0]]);
        }
        return ans;
    }
}