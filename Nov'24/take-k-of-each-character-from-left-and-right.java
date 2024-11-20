// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/ 

class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> a = new HashMap<>();
        a.put('a', 0);
        a.put('b', 0);
        a.put('c', 0);
        for (char x : s.toCharArray()) {
            a.put(x, a.get(x) + 1);
        }
        if (a.get('a') < k || a.get('b') < k || a.get('c') < k) {
            return -1;
        }
        int n = s.length(), l = 0, r = 0, m = 0;
        for (r = 0; r < n; r++) {
            char x = s.charAt(r);
            a.put(x, a.get(x) - 1);
            while (l <= r && (a.get('a') < k || a.get('b') < k || a.get('c') < k)) {
                x = s.charAt(l++);
                a.put(x, a.get(x) + 1);
            }
            m = Math.max(r - l + 1, m);
        }
        return n - m;
    }
}