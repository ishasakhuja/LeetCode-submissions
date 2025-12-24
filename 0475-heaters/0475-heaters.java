class Solution {
    boolean canCover(int[] houses, int[] heaters, int rad) {
        int i = 0;

        for (int h : heaters) {
            int left = h - rad;
            int right = h + rad;

            while (i < houses.length && houses[i] >= left && houses[i] <= right) {
                i++;
            }

            if (i == houses.length) return true;
        }

        return i == houses.length;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        int ho = houses.length;
        Arrays.sort(heaters);
        int max = Math.max(houses[ho - 1] - houses[0], Math.max(heaters[heaters.length - 1] - heaters[0], Math.max(heaters[heaters.length - 1] - houses[0], houses[ho - 1] - heaters[0])));

        int ans = 0;
        int l = 0;
        int h = max;

        while (l <= h) {
            int mid = l + (h - l)/2;
            if (canCover(houses, heaters, mid)) {
                ans = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }
}