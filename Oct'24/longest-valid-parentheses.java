// https://leetcode.com/problems/longest-valid-parentheses/ 
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()"

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), ans = 0;
        Stack<Integer> a = new Stack<>();
        a.push(-1);
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == '(') {
                a.push(i);
            } else {
                a.pop();
                if (!a.empty()) {
                    ans = Math.max(ans, i - a.peek());
                } else {
                    a.push(i);
                }
            }
        }
        return ans;
    }
}