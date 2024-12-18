// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] ans = prices.clone();
        for (int i = 0; i < ans.length; i++) {
            while (!s.isEmpty() && prices[i] <= prices[s.peek()]) {
                ans[s.pop()] -= prices[i];
            }
            s.push(i);
        }
        return ans;
    }
}