// https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/

class Solution {
    public long pickGifts(int[] g, int k) {
        long ans=0;
        Arrays.sort(g);
        for(int i=0;i<k;i++){
            g[g.length-1]=(int)Math.sqrt(g[g.length-1]);
            Arrays.sort(g);
        }
        for(int t:g){
            ans+=t;
        }
        return ans;
    }
}