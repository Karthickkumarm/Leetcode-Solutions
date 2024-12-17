// https://leetcode.com/problems/construct-string-with-repeat-limit/description/ 

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] a = new int[26];
        int l = 0, r = 25;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        while (r >= 0) {
            int k = repeatLimit;
            while (r >= 0 && a[r] == 0) {
                r -= 1;
            }
            if (r < 0) {
                break;
            }
            l = r - 1;
            while (l >= 0 && a[l] == 0) {
                l -= 1;
            }
            while (a[r] > 0 && k > 0) {
                k -= 1;
                ans.append((char) (r + 'a'));
                a[r] -= 1;
            }
            if (a[r] > 0) {
                if (l >= 0) {
                    ans.append((char) (l + 'a'));
                    a[l] -= 1;
                } else {
                    break;
                }
            }
        }
        return ans.toString();
    }
}