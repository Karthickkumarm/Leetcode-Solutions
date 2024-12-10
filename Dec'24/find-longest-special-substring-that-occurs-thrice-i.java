// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/

class Solution {
    public int maximumLength(String s) {
        s += " ";
        int l = 1, r = s.length()-1;
        while (l < r) {
            int[] c = new int[26];
            int m = l + (r - l) / 2, count = 1, k = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    int index = s.charAt(i - 1) - 'a';
                    if (count >= m) {
                        c[index] += count - m + 1;
                    }
                    if (c[index] >= 3) {
                        k = 1;
                        break;
                    }
                    count = 1;
                } else {
                    count += 1;
                }
            }
            if (k == 1) {
                l = ++m;
            } else {
                r = m;
            }
        }
        if(l!=1){
            return l-1;
        }
        return -1;
    }
}