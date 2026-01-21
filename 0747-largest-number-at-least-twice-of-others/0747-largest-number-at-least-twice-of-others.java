class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int nex = -1;
        int ind = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                nex = max;
                max = nums[i];
                ind = i;
            }
            else nex = Math.max(nex, nums[i]);
        }

        if (max < nex*2) return -1;
        return ind;
    }
}