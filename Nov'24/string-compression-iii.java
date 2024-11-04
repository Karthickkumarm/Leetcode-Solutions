// https://leetcode.com/problems/string-compression-iii/description/ 

class Solution {
    public String compressedString(String word) {
        int c = 1;
        char x = word.charAt(0);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == x && c < 9) {
                c += 1;
            } else {
                ans.append(c).append(x);
                x = word.charAt(i);
                c = 1;
            }
        }
        ans.append(c).append(x);
        return ans.toString();
    }
}
