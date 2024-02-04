/*
Time Complexity: O(n^2)
Space Complexity: O(1) (Modified input matrix)
*/

class Solution {
public:
    int n;
    vector<vector<int>> grid;

    //there can be only 3 ancestor of a cell
    int get_min_ancestor(int i, int j){
      int ans = INT_MAX;

      if(i>0)  ans = min(ans, grid[i-1][j]);
      if(i>0 && j>0)  ans = min(ans, grid[i-1][j-1]);
      if(i>0 && j<n-1)  ans = min(ans, grid[i-1][j+1]);

      return ans == INT_MAX ? 0 : ans;
    }

    int minFallingPathSum(vector<vector<int>>& matrix) {
      n = matrix.size();
      
      grid = matrix;
      //use tabulation to fill up the sum until a cell i,j
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          grid[i][j] += get_min_ancestor(i,j);
        }
      }

      int ans = INT_MAX;
      for(int j=0;j<n;j++)  ans = min(ans, grid[n-1][j]);
      
      return ans;
    }
};
