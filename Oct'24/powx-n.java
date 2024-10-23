// https://leetcode.com/problems/powx-n/

class Solution {
    public double myPow(double x, long n) {
        double ans = 1.0;
        long temp = n < 0 ? (n * -1) : n;
        while (temp > 0) {
            if (temp % 2 == 0) {
                x *= x;
                temp /= 2;
            } else {
                ans *= x;
                temp -= 1;
            }
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}