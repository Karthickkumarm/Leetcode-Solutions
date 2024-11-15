// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/ 

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, l = 0, ans = 0;
        int r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        ans = r;
        while (l < r) {
            while (r < n && arr[l] > arr[r]) {
                ++r;
            }
            ans = Math.min(r - l - 1, ans);
            if (arr[l] > arr[l + 1]) {
                break;
            }
            l += 1;
        }
        return ans;

    }
}