class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size()==0)
            return 0;
        int n=A.size();
        int B[n][n];
        for(int j=0;j<n;j++)
            B[0][j]=A[0][j];
        for(int i=1;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(j==0)
                    B[i][j]=A[i][j]+min(B[i-1][j],B[i-1][j+1]);
                else if(j==n-1)
                    B[i][j]=A[i][j]+min(B[i-1][j],B[i-1][j-1]);
                else
                    B[i][j]=A[i][j]+min(B[i-1][j+1],min(B[i-1][j],B[i-1][j-1]));
            }
        int m=B[n-1][0];
        for(int j=1;j<n;j++)
        {
            if(B[n-1][j]<m)
                m=B[n-1][j];
        }
        return m;
    }
};