class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(n);
        for(auto i:prerequisites){
            adj[i[1]].push_back(i[0]);
        }
        vector<int> indegree(n);
        for(auto i:adj){
            for(auto j:i){
                indegree[j]++;
            }
        }
        queue<int> q;
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.push(i);
            }
        }
        vector<int> res;
        while(!q.empty()){
            int node=q.front();
            q.pop();
            res.push_back(node);
            for(auto i:adj[node]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.push(i);
                }
            }
        }
        return res.size()==n?res:vector<int>{};
    }
};