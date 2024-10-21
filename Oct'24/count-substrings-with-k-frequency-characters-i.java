// https://leetcode.com/contest/weekly-contest-420/problems/count-substrings-with-k-frequency-characters-i/
// Input: s = "abacb", k = 2

// Output: 4

// Explanation:

// The valid substrings are:

// "aba" (character 'a' appears 2 times).
// "abac" (character 'a' appears 2 times).
// "abacb" (character 'a' appears 2 times).
// "bacb" (character 'b' appears 2 times).


class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            int[] f = new int[26];
            for (int j = i; j < n; j++) {
                f[s.charAt(j) - 'a']++;
                boolean v = false;
                for (int a : f) {
                    if (a >= k) {
                        v = true;
                        break;
                    }
                }
                if (v) {
                    ans += 1;
                }
            }
        }
        return ans;

    }
}