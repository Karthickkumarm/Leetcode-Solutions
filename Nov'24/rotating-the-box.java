// https://leetcode.com/problems/rotating-the-box/description/

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length, c = box[0].length;
        char[][] ans = new char[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[i][j] = '.';
            }
        }
        for (int i = 0; i < r; i++) {
            int k = c - 1;
            for (int j = c - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    ans[k][r - i - 1] = '#';
                    k -= 1;
                } else if (box[i][j] == '*') {
                    ans[j][r - i - 1] = '*';
                    k = j - 1;
                }
            }
        }
        return ans;
    }
}