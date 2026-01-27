class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2*w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] ne = pq.poll();
            int d = ne[1];
            int v = ne[0];

            if (v == n - 1) return d;
            if (d > dist[v]) continue;

            for (int[] edge : adj.get(v)) {
                int neigh = edge[0];
                int w = edge[1];
                if (dist[v] + w < dist[neigh]) {
                    dist[neigh] = dist[v] + w;
                    pq.add(new int[]{neigh, dist[neigh]});
                }
            }
        }
        return -1;
    }
}