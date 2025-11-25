class Solution {

    int dfs(List<List<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;
        int ans = 0;

        for (int n : adj.get(node)) {
            if (!vis[Math.abs(n)]) {
                if (n > 0) ans += 1;
                ans += dfs(adj, vis, Math.abs(n));
            }
        }
        return ans;
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            int u = c[0];
            int v = c[1];
            adj.get(u).add(v);
            adj.get(v).add(-u);
        }

        boolean[] vis = new boolean[n];
        return dfs(adj, vis, 0);
    }
}