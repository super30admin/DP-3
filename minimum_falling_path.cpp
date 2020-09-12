// Time Complexity : O(3^n)
// Space Complexity : O(3^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1.Edge case
//A. return if A.size() is zero
//2. Calculate the path : Recursion is used
//A. Recurse for the first row of the matrix
//B. Recurse for row_index+1 , col_index-1, col_index, col_index-1
//B. When the size reached is greater thean the row length return after storing the result.

class Solution {
public:
    int rows, cols;
    int result=INT_MAX;
    int minFallingPathSum(vector<vector<int>>& A) {
        //edge
        if(A.size()==0){
            return 0;
        }
        if(A.size()==1){
            for(int i=0;i< A[0].size();i++){
                result = min(result, A[0][i]);
            }
            return result;
        }
        //Sort each row and then find the first index path
        rows= A.size();
        cols = A[0].size();
        for(int i=0;i< A.size();i++){
            recurse(A, 0, i, 0);
           // cout<<result<<"\n";
        }
        return result;
    }
    
    void recurse(vector<vector<int>>& A,int row_index, int col_index, int curr_sum){
        //edge
        if(row_index == rows){
            result = min(result, curr_sum);
            return;
        }
        
        //recurse for row_index+1 , col_index-1, col_index, col_index-1
        curr_sum = curr_sum + A[row_index][col_index];
        recurse(A, row_index+1, col_index, curr_sum);
        if(col_index-1 >=0){
            recurse(A,  row_index+1, col_index-1, curr_sum);
        }
        if(col_index+1<cols){
            recurse(A,  row_index+1, col_index+1, curr_sum);
        }
    }
};




// Time Complexity : O(mn)
// Space Complexity : O(n) (2 array are used of size n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach (Similar to paint house problems)
//1.Edge case
//A. return if A.size() is zero
//2. Calculate the path : Array method is used
//A.  An array is created to calculate the value, second is store the previous vale
//B.  Value at the begining, middle and end is calculated
class Solution {
    int calculation_min_path(vector<vector<int>>& A){
     vector<int> min_path_count(A[0].begin(), A[0].end());
        
     vector<int> temp_min_path_count(min_path_count.begin(), min_path_count.end());
     int minimum_element = INT_MAX;
     //Complexity of O(mn)   
     for(int n=1; n<A.size(); n++){
         for(int m=0; m< A[0].size(); m++){
             //begin
             if(m==0){
                 min_path_count[m] = A[n][m] + min(temp_min_path_count[m], temp_min_path_count[m+1]);
             }
             //end
             else if(m==A[0].size()-1){
                 min_path_count[m] = A[n][m] + min(temp_min_path_count[m], temp_min_path_count[m-1]);
             }
             //middle
             else{
               min_path_count[m] = A[n][m] + min(temp_min_path_count[m], min(temp_min_path_count[m+1],temp_min_path_count[m-1]));  
             }
         }
         for(int m=0; m< A[0].size(); m++){
             temp_min_path_count[m] = min_path_count[m];
             }
         }
    
     for(int m=0; m< A[0].size(); m++){
             if(min_path_count[m]<minimum_element ){
                 minimum_element = min_path_count[m];
             }
     }
      return minimum_element;  
    }
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        //1.A
        if(A.size()==0){
            return 0;
        }
        //2
        return calculation_min_path(A);
    }
};


// Time Complexity : O(mn)
// Space Complexity : O(mn)
//2D dp matrix is used to store the result
class Solution {
public:
    int rows, cols;
    int result=INT_MAX;
    int minFallingPathSum(vector<vector<int>>& A) {
        //edge
        if(A.size()==0){
            return 0;
        }
        rows= A.size();
        cols = A[0].size();
        vector<vector<int>> dp(rows,vector<int>(cols,0));
        
        for(int j=0; j<cols;j++){
             dp[0][j] =  A[0][j];
         }
        
        int prev_col, curr_col, next_col;
        for(int i=1;i<rows;i++){
            for(int j=0; j<cols;j++){
                prev_col = INT_MAX;
                next_col = INT_MAX;
                
                if(j-1 >=0)
                    prev_col = dp[i-1][j-1];
        
                curr_col = dp[i-1][j];
                
                if(j+1 < cols)
                    next_col = dp[i-1][j+1];
                
                dp[i][j] = A[i][j] + min(prev_col, min(curr_col,next_col));
            }
        }
        
         for(int j=0; j<cols;j++){
             result = min(result, dp[rows-1][j]);
         }
         return result;
    }
        
};

