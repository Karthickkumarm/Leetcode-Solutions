// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/ 

class Solution {
    public boolean p(int x, int[] a, int s) {
        int k = 0;
        for (int a1 : a) {
            k += (a1 + x - 1) / x;
        }
        return k > s;
    }

    public int minimizedMaximum(int n, int[] q) {
        int l = 1, r = q[0], ans = 0;
        for (int x : q) {
            if (x > r) {
                r = x;
            }
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (p(m, q, n)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}