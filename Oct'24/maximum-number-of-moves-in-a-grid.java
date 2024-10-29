// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/

class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }
        int maxMoves = 0;
        for (int i = 0; i < rows; i++) {
            maxMoves = Math.max(maxMoves, backtrack(grid, i, 0, memo));
        }
        return maxMoves;
    }

    private int backtrack(int[][] grid, int i, int j, int[][] memo) {
        if (j == grid[0].length - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int maxMoves = 0;
        for (int k = -1; k <= 1; k++) {
            int newI = i + k;
            if (newI >= 0 && newI < grid.length && grid[newI][j + 1] > grid[i][j]) {
                maxMoves = Math.max(maxMoves, 1 + backtrack(grid, newI, j + 1, memo));
            }
        }
        memo[i][j] = maxMoves;
        return maxMoves;
    }
}