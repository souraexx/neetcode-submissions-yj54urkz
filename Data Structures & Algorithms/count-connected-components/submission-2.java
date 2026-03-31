class Solution {

    class DisJointSet {
        int parent[];
        int size[];

        public DisJointSet(int v) {
            parent = new int[v+1];
            size = new int[v+1];

            for (int i=0;i<=v;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int x) {
            if (parent[x]!=x) {
                parent[x] = findParent(parent[x]); // path compression
            }
            return parent[x];
        }

        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv) {
                return; // already part of the same component
            }
            if (size[pu]<size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }


    public int countComponents(int n, int[][] edges) {
        DisJointSet dsu = new DisJointSet(n);
        for (int edge[]:edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.findParent(u)!=dsu.findParent(v)) {
                dsu.unionBySize(u,v);
            }
        }
        int count = 0;
        for (int i=0;i<n;i++) {
            if (dsu.findParent(i)==i) {
                count++;
            }
        }
        return count;
    }
}
