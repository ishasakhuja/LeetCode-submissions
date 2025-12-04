class Solution {
    public int countCollisions(String directions) {
        int l = 0;
        int r = directions.length() - 1;

        while (l <= r && directions.charAt(l) == 'L') l++;
        while (l <= r && directions.charAt(r) == 'R') r--;

        int count = 0;

        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') count++;
        }

        return count;
    }
}