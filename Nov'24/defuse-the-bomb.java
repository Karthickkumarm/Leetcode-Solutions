// https://leetcode.com/problems/defuse-the-bomb/description/ 

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, i = 0, j = 0, a = 0;
        int[] ans = new int[n];
        for (i = 0; i < (n + Math.abs(k)); i++) {
            a += code[i % n];
            if ((i - j + 1) > Math.abs(k)) {
                a -= code[j % n];
                j = (j + 1) % n;
            }
            if ((i - j + 1) == Math.abs(k)) {
                if (k > 0) {
                    ans[(j - 1 + n) % n] = a;
                } else if (k < 0) {
                    ans[(i + 1) % n] = a;
                }
            }
        }
        return ans;
    }
}