//931. Minimum Falling Path Sum

/*
Greedy fails and exhaustive TLE
Do DP: Take minimum from the prev row; while only moving diagonally left/right and straight up
Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {

        // greedy wont work take this [1,4,3][7,6,2][2,1,2]

        /*
        // exhaustive - TLE
        int ret = INT_MAX;
        for(int i=0; i<matrix[0].size();i++)
            ret = min(ret, helper(matrix,0,i));

        return ret;
        */
        //tabulation
        int n = matrix.size();
        vector<vector<int>> dp(n,vector<int>(n));

        //copy the same first row
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        //loop from row 2
        for(int i=1; i<n;i++){
            for(int j=0; j<n;j++){
                if(j==0)
                dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1]);
                else if(j==n-1)
                dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j-1]);
                else
                dp[i][j] = matrix[i][j] + min(dp[i-1][j], min(dp[i-1][j-1], dp[i-1][j+1]));
            }
        }

        int minPath = INT_MAX;
        for(int i=0; i<n; i++)
        minPath = min(minPath, dp[n-1][i]);

        return minPath;
    }

    /*
    int helper(vector<vector<int>>&matrix, int row, int col){

        int n = matrix.size();
        //base
        if (row < 0 || row > n - 1 || col < 0 || col > n - 1) return INT_MAX;
        if (row == n-1 && (col >=0 || col < n)) return matrix[row][col];

        //logic
        int case1 = helper(matrix,row+1,col-1);
        int case2 = helper(matrix,row+1,col);
        int case3 = helper(matrix,row+1,col+1);

        return matrix[row][col]+min(case1, min(case2,case3));

    }
    */

    /*
    //you have complicated this
    int helper(vector<vector<int>>& matrix, int row, int col, int minPath) {

        int n = matrix.size();
        // base
        if (row > n - 1 || col > n - 1)
            return minPath;

        // logic
        // check edges - first col - go down and diagonal right only
        if (col == 0 && row != n - 1) {
            // choose
            int case1 =
                helper(matrix, row + 1, col, matrix[row][col] + minPath);
            int case2 =
                helper(matrix, row + 1, col + 1, matrix[row][col] + minPath);

            // not choose
            int case3 = helper(matrix, row, col + 1, minPath);
            return min(min(case1, case2), case3);

        }
        // last column - go down and diagonal left only
        else if (col == n - 1 && row != n - 1) {

            // choose
            int case1 =
                helper(matrix, row + 1, col - 1, matrix[row][col] + minPath);
            int case2 =
                helper(matrix, row + 1, col, matrix[row][col] + minPath);

            // not choose
            int case3 = helper(matrix, row, col + 1, minPath);
            return min(min(case1, case2), case3);

        } else {
            // choose
            int case1 =
                helper(matrix, row + 1, col - 1, matrix[row][col] + minPath);
            int case2 =
                helper(matrix, row + 1, col, matrix[row][col] + minPath);
            int case3 =
                helper(matrix, row + 1, col + 1, matrix[row][col] + minPath);

            // not choose
            int case4 = helper(matrix, row, col + 1, minPath);

            return min(min(case1, case2), min(case3, case4));
        }

        return 9999;
        
    }*/
};