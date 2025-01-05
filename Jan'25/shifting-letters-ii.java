// https://leetcode.com/problems/shifting-letters-ii/description/

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] p = new int[s.length() + 1];
        char[] ans = new char[s.length()];
        for (int[] k : shifts) {
            p[k[0]] += (k[2] == 1) ? 1 : -1;
            p[k[1] + 1] -= (k[2] == 1) ? 1 : -1;
        }
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            t += p[i];
            ans[i] = (char) ('a' + (((s.charAt(i) - 'a' + t) % 26 + 26) % 26));
        }
        return new String(ans);
    }
}