// https://leetcode.com/problems/counting-words-with-a-given-prefix/description/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans=0;
        for(String s:words){
            if(s.startsWith(pref)){
                ans+=1;
            }
        }
        return ans;
    }
}