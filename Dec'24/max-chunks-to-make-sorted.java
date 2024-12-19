// https://leetcode.com/problems/max-chunks-to-make-sorted/description/

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, p = 0, index = 0;
        for (int i = 0; i < arr.length; i++) {
            index += i;
            p += arr[i];
            if (p == index) {
                ans += 1;
            }
        }
        return ans;
    }
}