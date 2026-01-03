class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long x = 6, y = 6;

        for (int i = 2; i <= n; i++) {
            long nx = (3 * x + 2 * y) % MOD;
            long ny = (2 * x + 2 * y) % MOD;
            x = nx;
            y = ny;
        }

        return (int) ((x + y) % MOD);
    }
}