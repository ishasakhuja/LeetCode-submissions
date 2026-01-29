class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[26][26];
        int n = original.length;
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < 26; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            graph[u][v] = Math.min(graph[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][k] == Integer.MAX_VALUE)
                    continue;
                for (int j = 0; j < 26; j++) {
                    if (graph[k][j] == Integer.MAX_VALUE)
                        continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        long total = 0;
        int m = source.length();

        for (int i = 0; i < m; i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (u != v) {
                if (graph[u][v] == Integer.MAX_VALUE) {
                    return -1;
                }
                total += graph[u][v];
            }
        }

        return total;
    }
}