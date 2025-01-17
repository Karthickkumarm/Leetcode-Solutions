// https://leetcode.com/problems/neighboring-bitwise-xor/description/

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=0;
        for(int x: derived){
                n^=x;
        }
        return 0==n;
    }
}