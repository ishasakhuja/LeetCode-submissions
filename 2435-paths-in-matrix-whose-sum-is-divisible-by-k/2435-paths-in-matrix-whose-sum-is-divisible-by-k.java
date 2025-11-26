class Solution {
    static int mod = (int)1e9 + 7;

    private int helper(int[][] grid, int i, int j, int k, int sum, int[][][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        sum = (sum + grid[i][j])%k;
        if (dp[i][j][sum] != -1) return dp[i][j][sum];

        if (i == 0 && j == 0) return sum == 0 ? 1 : 0;

        int paths = helper(grid, i - 1, j, k, sum, dp) + helper(grid, i, j - 1, k, sum, dp);

        return dp[i][j][sum] = paths;
    }


    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        for (int[][] tab : dp) {
            for (int[] row : tab) Arrays.fill(row, -1);
        }

        return helper(grid, n - 1, m - 1, k, 0, dp);
    }
}