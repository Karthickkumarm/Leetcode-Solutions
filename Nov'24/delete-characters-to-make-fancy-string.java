// https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class Solution {
    public String makeFancyString(String s) {
        int j=2;
        if(s.length()<3){
            return s;
        }
        char[] ans=s.toCharArray();
        for(int i=2;i<s.length();i+=1){
            if(ans[i]!=ans[j-1] || ans[i]!=ans[j-2]){
                ans[j++]=ans[i];
            }
        }
        return new String(ans,0,j);
        
    }
}