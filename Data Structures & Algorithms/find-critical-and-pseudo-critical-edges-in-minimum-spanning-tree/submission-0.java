class Solution {
    class DisjointSet {
        int[] parent;
        int[] size;
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findParent(int u) {
            if (parent[u]!=u) {
                parent[u] = findParent(parent[u]); // path compression
            }
            return parent[u];
        }
        boolean unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu != pv) {
                if (size[pu] < size[pv]) {
                    parent[pu] = parent[pv];
                    size[pv] += size[pu];
                } else {
                    parent[pv] = parent[pu];
                    size[pu] += size[pv];
                }
                return true;
            }
            return false;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;

        int[][] newEdge = new int[m][4];

        List<Integer> pseudoEdge = new ArrayList<>();
        List<Integer> criticalEdge = new ArrayList<>();
        
        for (int i=0; i<m; i++) {
            newEdge[i][0] = edges[i][0]; // copy u
            newEdge[i][1] = edges[i][1]; // copy v
            newEdge[i][2] = edges[i][2];  // copy cost
            newEdge[i][3] = i; // store indices as during sort the original indices will be lost
        }
        
        Arrays.sort(newEdge, (a,b)->a[2]-b[2]); // sort by cost

        int minCost = kruskal(n, newEdge, -1, -1); // n, edges, edge to be forced, edge to be skipped

        for (int i=0; i<m; i++) {
            // skip the edge
            int currCost = kruskal(n, newEdge, -1, i);
            if (currCost > minCost) {
                criticalEdge.add(newEdge[i][3]);
            } else {
                // force this edge
                currCost = kruskal(n, newEdge, i, -1);
                if (currCost == minCost) {
                    pseudoEdge.add(newEdge[i][3]);
                }
            }
        }

        return Arrays.asList(criticalEdge, pseudoEdge);
    }

    int kruskal(int n, int edges[][], int forceEdge, int skipEdge) {
        
        DisjointSet ds = new DisjointSet(n);
        int cost = 0;

        if (forceEdge != -1) {
            ds.unionBySize(edges[forceEdge][0], edges[forceEdge][1]);
            cost += edges[forceEdge][2];
        }

        for (int i=0;i<edges.length; i++) {
            if (i == skipEdge) continue;
            if (ds.unionBySize(edges[i][0], edges[i][1]) == true) {
                cost += edges[i][2];
            }
        }

        for (int i=1;i<n;i++) {
            if (ds.findParent(i) != ds.findParent(0)) {
                return (int)1e9;
            } 
        }
        return cost;
    }






}