// https://leetcode.com/problems/minimum-cost-for-tickets/description/

class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int ls = days[days.length - 1];
        int[] a = new int[ls + 1];
        Set<Integer> d = new HashSet<>();
        for (int i : days) {
            d.add(i);
        }
        for (int i = 1; i < ls + 1; i++) {
            if (!d.contains(i)) {
                a[i] = a[i - 1];
            } else {
                a[i] = Math.min(a[i - 1] + cost[0],
                        Math.min(a[Math.max(0, i - 7)] + cost[1], a[Math.max(0, i - 30)] + cost[2]));
            }
        }
        return a[ls];
    }
}