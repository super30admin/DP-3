//time complexity: O(n^2)
//space complexity:O(n)
//approach: brute force
//solved on leetcode? yes, but only 39/69 test cases pass
//problem faced? yes, I was able to think of the approach but was unable to code it so I saw the solution.
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int r=A.size();
        int c=A[0].size();
        int d=0;
        for(int i=1; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                d=A[i-1][j];
                if(j>0)
                {
                    d=min(d,A[i-1][j-1]);
                }
                if(j<c-1)
                {
                    d=min(d,A[i-1][j+1]);
                }
                A[i][j]=A[i][j]+d;
            }
        }
        int ans=INT_MAX;
        for(int i=0;i<c;i++)
            ans=min(ans,A[r-1][i]);
        return ans;
        
    }
};