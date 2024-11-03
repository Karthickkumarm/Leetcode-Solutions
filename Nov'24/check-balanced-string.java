// https://leetcode.com/contest/weekly-contest-422/problems/check-balanced-string/ 

class Solution {
    public boolean isBalanced(String num) {
        int e = 0, o = 0;
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            if (i % 2 == 0) {
                e += x;
            } else {
                o += x;
            }
        }
        return (e == o) ? true : false;
    }
}