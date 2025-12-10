class Solution {
    int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        int evens = 5;
        int odds = 4;
        int odes = 20;
        long ans = 0;
        boolean isExtra = n%2 == 1;
        long equals = n/2;
        ans += modPow(odes, equals);
        if (isExtra) ans *= evens;
        return (int) (ans % MOD);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}