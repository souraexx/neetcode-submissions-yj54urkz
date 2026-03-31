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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet dsu = new DisJointSet(n);
        Map<String, Integer> accountMap = new HashMap<>();

        for (int i=0;i<n;i++) {
            for (int j=1;j<accounts.get(i).size();j++) {
                String email = accounts.get(i).get(j);
                if (!accountMap.containsKey(email)) {
                    accountMap.put(email,i);
                } else {
                    dsu.unionBySize(i, accountMap.get(email));
                }
            }
        }

        Map<Integer, List<String>> mergedMap = new HashMap<>();
        for (String email: accountMap.keySet()) {
            int parent = dsu.findParent(accountMap.get(email));
            mergedMap.computeIfAbsent(parent, k->new ArrayList<>()).add(email);
        } 
        List<List<String>> result = new ArrayList<>();
        for (int key: mergedMap.keySet()) {
            List<String> emails = mergedMap.get(key);
            Collections.sort(emails);
            String parent = accounts.get(key).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(parent);
            temp.addAll(emails);
            result.add(temp);
        }
        return result;
    }
}