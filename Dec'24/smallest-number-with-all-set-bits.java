// https://leetcode.com/contest/weekly-contest-426/problems/smallest-number-with-all-set-bits/description/ 

class Solution {
    public int smallestNumber(int n) {
        while((n&(n+1))!=0){
            n|=n>>1;
        }
        return n;
    }
}