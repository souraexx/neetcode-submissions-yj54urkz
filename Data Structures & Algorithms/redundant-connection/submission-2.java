class Solution {

    class DisJointSet {
        int[] parent;
        int [] size;

        public DisJointSet(int n) {
            parent = new int[n+1];
            size = new int[n+1];

            for (int i=0; i<=n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int x) {
            if (parent[x]==x) {
                return x;
            }
            parent[x] = findParent(parent[x]); // path compression
            return parent[x];
        }

        public void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) return;

            if (size[u]<size[v]) {
                parent[pu] = pv;
                size[v] += size[u];
            } else {
                parent[pv] = pu;
                size[u] += size[v];
            }
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisJointSet dsu = new DisJointSet(n);

        for (int edge[]:edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.findParent(u) != dsu.findParent(v)) {
                dsu.unionBySize(u,v);
            } else {
                return edge;
            }
        }

        return new int[] {};
    }
}
