class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem = 1;
        int c = 1;

        for (int i = 0; i < k; i++) {
            if (rem%k == 0) return c;
            rem = (rem * 10 + 1) % k;
            c++;
        }

        return -1;
    }
}