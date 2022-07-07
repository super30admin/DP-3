class Solution {
public:
    //TC-O(M*N)
    //SC-O(1)
    int minFallingPathSum(vector<vector<int>>& matrix) {
       int m=matrix.size();
        int n=matrix[0].size();
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]+=min({matrix[i-1][j],matrix[i-1][max(0,j-1)],matrix[i-1][min(n-1,j+1)]});
            }
        }
        int res=INT_MAX;
        for(int i=0;i<n;i++){
            res=min(res,matrix[m-1][i]);
        }
        return res;
    }
};