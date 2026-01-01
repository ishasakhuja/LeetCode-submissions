class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int countpos = 0;
        int countneg = 0;
        int n = nums.length;

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (prev != -1) {
                    countpos += (i - prev);
                    prev = -1;
                }
                else prev = i;
            }
        }
        if (prev != -1) countpos = Integer.MAX_VALUE;
        prev = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                if (prev != -1) {
                    countneg += (i - prev);
                    prev = -1;
                }
                else prev = i;
            }
        }
        if (prev != -1) countneg = Integer.MAX_VALUE;

        return Math.min(countpos, countneg) <= k;
    }
}