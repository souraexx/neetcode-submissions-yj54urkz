class Solution {
    class DisjointSet {
        int parent[];
        int size[];
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int u) {
            if (parent[u] == u) {
                return parent[u];
            }
            parent[u] = find(parent[u]); // path compression
            return parent[u];
        }
        void unionBySize(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                if (size[pu]<size[pv]) {
                    parent[pu] = pv;
                    size[pv] += size[pu];
                } else {
                    parent[pv] = pu;
                    size[pu] +=  size[pv];
                }
            }
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n==1) return true;
        int maxVal = 100001;
        DisjointSet dsu = new DisjointSet(n+maxVal); // store n nodes and its prime factors as n+prime factor for offset
        for (int i=0; i<n; i++) {
            int num = nums[i];
            for (int p=2; p*p<=num; p++) {
                if (num%p == 0) {
                    dsu.unionBySize(i, n+p);
                    while(num%p == 0) {
                        num/= p;
                    }
                }
            }
            if (num>1) {
                dsu.unionBySize(i, n+num);
            }
        }
        for (int i=1;i<n;i++) {
            if (dsu.find(0) != dsu.find(i)) {
                return false;
            }
        }
        return true;
    }

}