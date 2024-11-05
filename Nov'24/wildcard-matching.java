// https://leetcode.com/problems/wildcard-matching/description/

class Solution {
    public boolean isMatch(String s1, String s2) {
        int sl1 = 0, sl2 = 0, m = 0, e = -1;
        while (s1.length() > sl1) {
            if (s2.length() > sl2 && (s2.charAt(sl2) == '?' || s1.charAt(sl1) == s2.charAt(sl2))) {
                sl1 += 1;
                sl2 += 1;
            } else if (s2.length() > sl2 && s2.charAt(sl2) == '*') {
                e = sl2;
                m = sl1;
                sl2 += 1;
            } else if (e != -1) {
                sl2 = e + 1;
                m += 1;
                sl1 = m;
            } else {
                return false;
            }
        }
        while (s2.length() > sl2 && s2.charAt(sl2) == '*') {
            sl2 += 1;
        }
        if (sl2 == s2.length()) {
            return true;
        }
        return false;

    }
}