// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/ 

class Solution {
    public int maxScore(String s) {
        int a=0,b=0,c=0;
        for(char x: s.toCharArray()){
            if(x=='1'){
                a+=1;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                a-=1;
            }
            else{
                b+=1;
            }
            c=Math.max(c,a+b);
        }
        return c;
    }
}