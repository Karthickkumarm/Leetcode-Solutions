// https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/

class Solution {
    public boolean canChange(String s, String t) {
        String start=s.replace("_",""),target=t.replace("_","");
        int l=s.length(),i=0,j=0;
        if(!start.equals(target)){
            return false;
        }
        while(i<l && j<l){
            while(i<l && s.charAt(i) == '_'){
                i+=1;
            }
            while(j<l && t.charAt(j)=='_'){
                j+=1;
            }
            if(i<l && j<l){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
                if(s.charAt(i)=='L' && i<j){
                    return false;
                }
                if(s.charAt(i)=='R' && i>j){
                    return false;
                }
                i+=1;j+=1;
            }
        }
        return true;
    }
}