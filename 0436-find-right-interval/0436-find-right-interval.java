class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> tmp = new TreeMap<>();
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            tmp.put(intervals[i][0], i);
            maxi = Math.max(maxi, intervals[i][0]);
        }
        int[] ans = new int[intervals.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            Map.Entry<Integer, Integer> entry = tmp.ceilingEntry(end);
            if (entry != null) {
                ans[i] = entry.getValue();
            }
        }

        return ans;
    }
}