class Solution {
private:
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
    int minimumSemesters(int n, vector<vector<int>>& relations) {
        vector<vector<int>> adj(n+1);
        for(auto &i:relations){
            adj[i[0]].push_back(i[1]);
        }
        vector<bool> visited(n+1, false);
        vector<bool> pathVisited(n+1, false);
        stack<int> st;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(dfs(adj,visited,pathVisited,i,st)){
                    return -1;
                }
            }   
        }
        vector<int> topo;
        while(!st.empty()){
            topo.push_back(st.top());
            st.pop();
        }
        vector<int> dist(n+1,1);
        for(int node:topo){
            for(int adjacentNode:adj[node]){
                dist[adjacentNode] = max(dist[adjacentNode], 1+dist[node]);
            }
        }
        return *max_element(dist.begin(),dist.end());
    }
};