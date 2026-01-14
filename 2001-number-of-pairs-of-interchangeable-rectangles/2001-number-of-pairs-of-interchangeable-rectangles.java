class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> freq = new HashMap<>();

        for (int[] p : rectangles) {
            double frac = (double) p[0] / (double) p[1];
            freq.put(frac, freq.getOrDefault(frac, 0) + 1);
        }

        long ans = 0;

        for (double v : freq.values()) {
            // System.out.println(v);
            ans += (v * (v - 1))/2;
        }

        return ans;
    }
}