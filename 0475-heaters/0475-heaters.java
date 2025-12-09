class Solution {

    public boolean isPossible(int[] houses, int[] heaters, int mid) {
    int i = 0; // pointer to unheated house
    
    for (int h : heaters) {
        int left = h - mid;
        int right = h + mid;

        // cover houses while they fall within current heater's range
        while (i < houses.length && houses[i] >= left && houses[i] <= right) {
            i++;
        }

        if (i == houses.length) return true; // all houses covered
    }
    return i == houses.length;
}


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int high = Math.max(houses[houses.length - 1] - houses[0], Math.max(houses[houses.length - 1] - heaters[0], heaters[heaters.length - 1] - houses[0]));
        int low = 0;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (isPossible(houses, heaters, mid)) {
                high = mid - 1;
                ans = mid;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}