class Solution {
    bool dfs(vector<vector<int>> &adj, vector<bool> &visited, vector<bool> &pathVisited, int node, stack<int> &st){
        visited[node]=true;
        pathVisited[node]=true;
        for(int i:adj[node]){
            if(pathVisited[i])
                return true;
            if(!visited[i]){
                if(dfs(adj,visited,pathVisited,i,st))
                    return true;
            }
        }
        pathVisited[node]=false;
        st.push(node);
        return false;
    }
public:
    bool canFinish(int n, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(n+1);
        for(auto &i:prerequisites){
            adj[i[1]].push_back(i[0]);
        }
        vector<bool> visited(n+1, false);
        vector<bool> pathVisited(n+1, false);
        stack<int> st;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(dfs(adj,visited,pathVisited,i,st)){
                    return false;
                }
            }   
        }
        return true;
    }
};