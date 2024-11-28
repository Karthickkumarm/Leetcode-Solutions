// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/ 

class Solution {
    public int minimumObstacles(int[][] g) {
        int r = g.length, col = g[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { 0, 0, 0 });
        boolean[][] v = new boolean[r][col];
        v[0][0] = true;
        int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!dq.isEmpty()) {
            int[] cc1 = dq.pollFirst();
            int x = cc1[0], y = cc1[1], c = cc1[2];
            if (y == col - 1 && x == r - 1) {
                return c;
            }
            for (int[] dx : d) {
                int x1 = x + dx[0], y1 = y + dx[1];
                if ((0 <= x1 && x1 < r) && (0 <= y1 && y1 < col) && (!v[x1][y1])) {
                    v[x1][y1] = true;
                    if (g[x1][y1] == 0) {
                        dq.addFirst(new int[] { x1, y1, c });
                    } else {
                        dq.addLast(new int[] { x1, y1, c + 1 });
                    }
                }
            }
        }
        return -1;
    }
}