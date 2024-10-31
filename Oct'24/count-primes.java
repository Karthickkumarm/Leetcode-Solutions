// https://leetcode.com/problems/count-primes/description/ 

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] p = new boolean[n];
        int ans = 0;
        Arrays.fill(p, true);
        for (int i = 2; i < n; i++) {
            if (p[i]) {
                for (int j = i * 2; j < n; j += i) {
                    p[j] = false;
                }
                ans += 1;
            }
        }
        return ans;
    }
}