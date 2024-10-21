//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/
// Input: s = "ababccc"
// Output: 5
// Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
// Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.

import java.util.HashSet;

class Solution {
    public int maxUniqueSplit(String s) {
        return bt(0, s, new HashSet<>());
    }

    private int bt(int i, String s, HashSet<String> ss) {
        if (i == s.length()) {
            return 0;
        }
        int count = 0;
        for (int j = i; j < s.length(); j++) {
            String t = s.substring(i, j + 1);
            if (!ss.contains(t)) {
                ss.add(t);
                count = Math.max(count, 1 + bt(j+1, s, ss));
                ss.remove(t);
            }
        }
        return count;
    }
}