class Solution {
    public boolean checkOnesSegment(String s) {
        int flag = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' == 0) flag = 1;
            else if (flag == 1) return false;
        }
        return true;
    }
}