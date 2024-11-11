// https://leetcode.com/problems/prime-subtraction-operation/

class Solution {
    boolean prime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int m = nums[0];
        for (int n : nums) {
            if (n > m) {
                m = n;
            }
        }
        List<Integer> p = new ArrayList<>();
        p.add(0);
        p.add(0);
        for (int i = 2; i <= m; i++) {
            if (prime(i)) {
                p.add(i);
            } else {
                p.add(p.get(i - 1));
            }
        }
        int ans = 0;
        for (int n : nums) {
            int u = n - ans;
            if (u < 1) {
                return false;
            }
            int l = p.get(u - 1);
            if ((n - l) <= ans) {
                return false;
            }
            ans = n - l;
        }
        return true;
    }
}