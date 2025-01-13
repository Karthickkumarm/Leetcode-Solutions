// https://leetcode.com/problems/minimum-length-of-string-after-operations/description/

class Solution {
    public int minimumLength(String s) {
        int ans=0,n=s.length();
        int[] a =new int[26];
        for(char x: s.toCharArray()){
            a[x-'a']+=1;
        }
        for(int x:a){
            if(x>2){
                if(x%2==0){
                    ans+=x-2;
                }else{
                    ans+=x-1;
                }
            }
        }
        ans=n-ans;
        return ans;
    }
}