// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/

class Solution {
    public int maximumBeauty(int[] n, int k) {
        Arrays.sort(n);
        int ans=0,l=0,r=0;
        for(r=0;r<n.length;r++){
            while((n[r]-n[l]) > (2*k)){
                ++l;
            }
            ans=(ans<r-l+1)? (r-l+1):ans;
        }
        return ans;
    }
}