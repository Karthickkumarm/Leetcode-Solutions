// https://leetcode.com/problems/adding-spaces-to-a-string/description/

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans=new StringBuilder();
        int i=0,j=0;
        while(i<s.length() && j<spaces.length){
            if(i<spaces[j]){
                ans.append(s.charAt(i));i+=1;
            }else{
                ans.append(" ");j+=1;
            }
        }
        if(i<s.length()){
            for(int k=i;k<s.length();k++){
                ans.append(s.charAt(k));
            }
        }
        return ans.toString();
    }
}