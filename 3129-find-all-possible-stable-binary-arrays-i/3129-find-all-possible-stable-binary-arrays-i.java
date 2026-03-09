class Solution {

    int MOD = (int)1e9 + 7;
    int limit;
    Integer[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new Integer[zero + 1][one + 1][2][limit + 1];

        int startWithZero = dfs(zero - 1, one, 0, 1);
        int startWithOne = dfs(zero, one - 1, 1, 1);

        return (startWithZero + startWithOne) % MOD;
    }

    private int dfs(int z, int o, int last, int count) {
        if (z < 0 || o < 0) return 0;
        if (count > limit) return 0;

        if (z == 0 && o == 0) return 1;

        if (memo[z][o][last][count] != null) {
            return memo[z][o][last][count];
        }

        long ans = 0;

        if (last == 0) {
            // place another 0
            ans += dfs(z - 1, o, 0, count + 1);

            // switch to 1
            ans += dfs(z, o - 1, 1, 1);
        } else {
            // place another 1
            ans += dfs(z, o - 1, 1, count + 1);

            // switch to 0
            ans += dfs(z - 1, o, 0, 1);
        }

        return memo[z][o][last][count] = (int)(ans % MOD);
    }
}