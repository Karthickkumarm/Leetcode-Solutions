// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/ 

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j=0;
        for(int i=0;j<str2.length() && i<str1.length();i++){
            char x=str1.charAt(i),y=(char)((str1.charAt(i)-'a'+1)%26 +'a'),z=str2.charAt(j);
            if(x==z || y==z){
                j+=1;
            }
        }
        return str2.length()==j;
    }
}