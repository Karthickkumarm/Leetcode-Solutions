// https://leetcode.com/contest/biweekly-contest-142/problems/find-the-original-typed-string-i/ 


class Solution {
    public int possibleStringCount(String word) {
        int ans=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)){
                ans+=1;
            }
        }
        return ans;
    }
}