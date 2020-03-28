// Time Complexity : O(n^2)
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
