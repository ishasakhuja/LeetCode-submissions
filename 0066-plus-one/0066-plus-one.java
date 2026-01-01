class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) digits[i--] = 0;
        if (i < 0) {
            int[] ne = new int[digits.length + 1];
            ne[0] = 1;
            return ne;
        }
        digits[i]++;
        return digits;
    }
}