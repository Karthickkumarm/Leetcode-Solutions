// https://leetcode.com/contest/weekly-contest-420/problems/minimum-division-operations-to-make-array-non-decreasing/
// Input: nums = [25,7]

// Output: 1

// Explanation:

// Using a single operation, 25 gets divided by 5 and nums becomes [5, 7]

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            int curr = nums[i], next = nums[i + 1], ops = 0;
            int d = getGPD(curr);
            if (d <= 1) {
                return -1;
            }
            ops += 1;
            nums[i] = d;
            if (nums[i] > next) {
                return -1;
            }
            ans += ops;
        }
        return ans;
    }

    int getGPD(int a) {
        if (a <= 1) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                if (i < a) {
                    return i;
                }
                if ((a / i) < a) {
                    return a / i;
                }
            }
        }
        return 0;
    }
}