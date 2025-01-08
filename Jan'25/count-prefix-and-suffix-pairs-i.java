// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/ 

class Solution {
    public int countPrefixSuffixPairs(String[] w) {
        int ans=0;
        for(int i=0;i<w.length;i++){
            for(int j=i+1;j<w.length;j++){
                String x=w[i],y=w[j];
                if(y.endsWith(x) && y.startsWith(x)){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}