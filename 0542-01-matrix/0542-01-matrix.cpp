class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m=mat.size(), n=mat[0].size();
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.push({i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        vector<int> dir{0,1,0,-1,0};
        while(!q.empty()){
            int a=q.front().first, b=q.front().second;
            q.pop();
            for(int i=0; i<4; i++){
                int x=a+dir[i], y=b+dir[i+1];
                if(x>=0 && y>=0 && x<m && y<n && mat[x][y]==-1){
                    mat[x][y] = 1 + mat[a][b];
                    q.push({x,y});
                }
            }
        }
        return mat;
    }
};