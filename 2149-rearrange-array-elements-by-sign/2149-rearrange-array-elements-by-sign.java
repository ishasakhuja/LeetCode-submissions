class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> negs = new ArrayList<>();
        List<Integer> poss = new ArrayList<>();

        for (int i : nums) {
            if (i < 0) negs.add(i);
            else poss.add(i);
        }

        int j = 0;
        int k = 0;

        for (int i = 0; i <n; i++) {
            if (i%2 == 0) {
                nums[i] = poss.get(j++);
            }
            else nums[i] = negs.get(k++);
        }

        return nums;
    }
}