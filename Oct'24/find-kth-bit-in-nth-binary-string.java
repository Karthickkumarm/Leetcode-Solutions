// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
// Input: n = 3, k = 1
// Output: "0"
// Explanation: S3 is "0111001".
// The 1st bit is "0".

class Solution {
    public char findKthBit(int n, int k) {
        int length = (int) Math.pow(2, n) - 1, half;
        boolean invert = false;
        while (length > 1) {
            half = length / 2;
            if (k <= half) {
                length = half;
            } else if (k > (half + 1)) {
                k = 1 + length - k;
                length = half;
                invert = !invert;
            } else {
                return !invert ? '1' : '0';
            }
        }
        return !invert ? '0' : '1';
    }
}