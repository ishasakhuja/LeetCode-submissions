class Solution {
    private int dfs(int node, int parent, List<List<Integer>> adj, int[] good, int[] down) {
        int maxi = 0;
        for (int neighb : adj.get(node)) {
            if (neighb != parent) {
                maxi = Math.max(maxi, maxi + dfs(neighb, node, adj, good, down));
            }
        }

        return down[node] = good[node] == 1 ? maxi + 1 : maxi - 1;
    }

    private void dfs2(int node, int par, List<List<Integer>> adj, int[] good, int[] down, int[] up) {
        up[node] = down[node];
        if (par != -1) {
            if (down[node] <= 0 && up[par] > 0) {
                up[node] = up[par] + down[node];
            }
            else if (down[node] > 0) {
                up[node] = Math.max(up[node], up[par]);
            }
        }
        for (int neighb : adj.get(node)) {
            if (neighb != par) {
                dfs2(neighb, node, adj, good, down, up);
            }
        }
    }

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ed : edges) {
            int u = ed[0];
            int v = ed[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // boolean[] vis = new boolean[n];
        int[] down = new int[n];
        dfs(0, -1, adj, good, down);
        int[] up = new int[n];
        dfs2(0, -1, adj, good, down, up);
        return up;
    }
}