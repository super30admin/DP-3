// Time Complexity : O(nm) - number of rows n and m columns.
// Space Complexity : O(1) - Did not use extra space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size() == 0) return -INT_MIN;
        if(A.size() == 1) return *min_element(A[0].begin(), A[0].end());
        
        int path1, path2, path3;
        for(int row = 1; row < A.size(); ++row){
            for(int col = 0; col < A[0].size(); ++col){
                path1 = path2 = path3 = INT_MAX;
                if(col - 1 >= 0){
                    path1 = A[row][col] + A[row - 1][col - 1];
                }
                path2 = A[row][col] + A[row - 1][col];
                if(col + 1 < A[0].size()){
                    path3 = A[row][col] + A[row - 1][col + 1];
                }
                A[row][col] = min(path1, min(path2, path3));
                
            }
            
        }
        return *min_element(A[A.size() - 1].begin(), A[A.size() - 1].end());
    }
};