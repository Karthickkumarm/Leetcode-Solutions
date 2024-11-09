// https://leetcode.com/problems/minimum-array-end/description/ 

class Solution {
    public long minEnd(int n, int x) {
        long ans = x, x1 = 1, n1 = 1;
        while (n1 <= (n - 1)) {
            if ((x1 & x) == 0) {
                if ((n1 & (n - 1)) != 0) {
                    ans |= x1;
                }
                n1 <<= 1;
            }
            x1 <<= 1;
        }
        return ans;
    }
}