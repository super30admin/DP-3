// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
#include<vector>
#include<climits>
using namespace std;
class Solution {
private:
    int calculateMin(vector<vector<int>> &dir,int r,int c,int &n,vector<vector<int>>& matrix)
    {
        if(r==0)
            return 0;
        int ans = INT_MAX;
        for(auto e: dir)
        {
            int nr = r+e[0];
            int nc = c+e[1];
            if(nr<n && nr>=0 && nc < n && nc>=0)
            {
                ans = min(ans,matrix[nr][nc]); 
            }
        }
        return ans;
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        vector<vector<int>> dir = {{-1,0},{-1,1},{-1,-1}};
        int n = matrix.size();
        //vector<int> dp (n);
        int ans = INT_MAX;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j <n;j++)
            {
                matrix[i][j] += calculateMin(dir,i,j,n,matrix);
                //basically if we are are at the last row we start calculating minimum
                if(i==n-1)
                    ans = min(ans,matrix[i][j]);
            }
        }
        return ans;
        
    }
};