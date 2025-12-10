class Solution {
    public void generate(int n, int open, int close, List<String> lis, StringBuilder sb) {
        if (open == close && open == n) {
            lis.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            generate(n, open + 1, close, lis, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            generate(n, open, close + 1, lis, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> lis = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(n, 0, 0, lis, sb);
        return lis;
    }
}