class Solution {
    private:
    bool colour(vector<vector<int>> &graph, int node, int col, vector<int> &colours){
        colours[node]=!col;
        for(int i:graph[node]){
            if(colours[i]==colours[node]){
                return false;
            }
            if(colours[i]==-1 && !colour(graph,i,!col,colours)){
                return false;
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
                if(!colour(graph,i,0,colours)){
                    return false;
                }
            }
        }
        return true;
    }
};