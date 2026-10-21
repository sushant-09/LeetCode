class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] i:prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        int [] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i:adj.get(current)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(indegree[i]>0)
                return false;
        }
        return true;
    }
}