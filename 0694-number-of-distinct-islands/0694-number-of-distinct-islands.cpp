class Solution {
private:
    vector<int> dir{0,-1,0,1,0};
    vector<char> characters{'l','d','r','u'};
    void dfs(vector<vector<int>> &grid, int a, int b, vector<vector<bool>> &visited, string& s){
        visited[a][b]=true;
        for(int i=0; i<4; i++){
            int x=a+dir[i], y=b+dir[i+1];
            if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y]==1 && !visited[x][y]){
                s += (characters[i]);
                dfs(grid,x,y,visited,s);
                s += "#";
            }
        }
        // return s;
    }
public:
    int numDistinctIslands(vector<vector<int>>& grid) {
        int m=grid.size(), n=grid[0].size();
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        unordered_set<string> islands;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    string s="";
                    dfs(grid,i,j,visited,s);
                    islands.insert(s);
                }
            }
        }
        return islands.size();
    }
};