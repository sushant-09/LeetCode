class Solution {
    private:
    bool colour(vector<vector<int>> &graph, int node, vector<int> &colours){
        colours[node]=0;
        queue<int> q;
        q.push(node);
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(int i:graph[node]){
                if(colours[i]==colours[node]){
                    return false;
                }
                if(colours[i]==-1){
                    colours[i] = !colours[node];
                    q.push(i);
                }
            }
        }
        return true;
    }
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n=graph.size();
        vector<int> colours(n,-1);
        for(int i=0; i<n; i++){
            if(colours[i]==-1){
                if(!colour(graph,i,colours)){
                    return false;
                }
            }
        }
        return true;
    }
};