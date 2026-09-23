class Solution {
    private:
        bool dfs(vector<vector<int>>& adj, int node, vector<bool> &visited, vector<bool> &pathVisited, vector<bool> &isSafe){
            visited[node]=true;
            pathVisited[node]=true;
            for(int i:adj[node]){
                if(pathVisited[i]){
                    return true;
                }
                if(!visited[i] && dfs(adj,i,visited,pathVisited,isSafe)){
                    return true;
                }
            }
            isSafe[node]=true;
            pathVisited[node]=false;
            return false;
        }
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n=graph.size();
        vector<bool> visited(n,false);
        vector<bool> pathVisited(n,false);
        vector<bool> isSafe(n,false);
        for(int i=0; i<n;i++){
            if(!visited[i]){
                dfs(graph,i,visited,pathVisited,isSafe);
            }
        }
        vector<int> res;
        for(int i=0; i<n; i++){
            if(isSafe[i]){
                res.push_back(i);
            }
        }
        return res;
    }
};