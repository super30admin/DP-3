// Time Complexity : O(n*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int len = matrix.size();
        int i, j;
        int min_val;
        
        for(i = 1; i < len; i++)
        {
            for(j = 0; j < len; j++)
            {
                min_val = INT_MAX;
                
                if(j-1 >= 0)
                {
                    if(matrix[i-1][j-1] < min_val)
                    {
                        min_val = matrix[i-1][j-1];
                    }
                }
                
                if(matrix[i-1][j] < min_val)
                {
                    min_val = matrix[i-1][j];
                }
                
                if(j+1 < len)
                {
                    if(matrix[i-1][j+1] < min_val)
                    {
                        min_val = matrix[i-1][j+1];
                    }
                }
                cout << min_val << endl;
                matrix[i][j] += min_val;
            }
        }
        
        min_val = INT_MAX;
        
        for(i = 0; i < len; i++)
        {
            cout << matrix[len-1][i] << endl;
            if(matrix[len-1][i] < min_val)
            {
                min_val = matrix[len-1][i];
            }
        }
        
        return min_val;
    }
};