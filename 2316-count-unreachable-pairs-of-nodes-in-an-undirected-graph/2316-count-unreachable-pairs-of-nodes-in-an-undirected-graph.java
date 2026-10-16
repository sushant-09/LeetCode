class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0], v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        long remaining = n, res = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                long nodes = dfs(adj,i,visited);
                remaining = remaining - nodes;
                res += nodes*remaining;
            }
        }
        return res;
    }
    private long dfs(List<List<Integer>> adj, int node, boolean[] visited){
        visited[node]=true;
        long count=1;
        for(int i:adj.get(node)){
            if(!visited[i]){
                count += dfs(adj,i,visited);
            }
        }
        return count;
    }
}