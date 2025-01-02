//https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u');
        int[] ans = new int[queries.length];
        int[] p = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (v.contains(w.charAt(0)) && v.contains(w.charAt(w.length() - 1))) {
                p[i + 1] = p[i] + 1;
            } else {
                p[i + 1] = p[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = p[queries[i][1] + 1] - p[queries[i][0]];
        }
        return ans;
    }
}