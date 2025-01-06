// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

class Solution {
    public int[] minOperations(String boxes) {
        int l = 0, r = 0, a1 = 0, a2 = 0, l1 = boxes.length();
        int[] ans = new int[l1];
        for (int i = 0; i < l1; i++) {
            l += (boxes.charAt(i) - '0');
            ans[i] += a1;
            a1 += l;
            ans[l1 - i - 1] += a2;
            r += boxes.charAt(l1 - i - 1) - '0';
            a2 += r;
        }
        return ans;
    }
}