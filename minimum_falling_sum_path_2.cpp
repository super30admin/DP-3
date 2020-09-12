// Time Complexity : O(mn)
// Space Complexity : O(1)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Find min and second minimum of each row
//2. If the immediate value above is equal to first_min add second_min, else add first min
//3. Store the curr roe min and max in temp variables and update the global values
//4. return the last row minimum


class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& arr) {
        //edge
        if(arr.size()==0){
            return 0;
        }
        
        //logic
        int rows = arr.size();
        int cols = arr[0].size();
        int first_min =INT_MAX, second_min = INT_MAX; 
        
        for(int j=0;j<cols;j++){
            if(first_min > arr[0][j]){
                second_min = first_min;
                first_min = arr[0][j];
            }else if(second_min > arr[0][j]){
                second_min = arr[0][j];
            }
        }
        
        
        
        for(int i=1;i<rows;i++){
            int curr_first_min =INT_MAX, curr_second_min = INT_MAX; 
            for(int j=0;j<cols;j++){
                if(arr[i-1][j] == first_min){
                    arr[i][j] = arr[i][j] + second_min;
                }else{
                    arr[i][j] = arr[i][j] + first_min;
                }
                if(curr_first_min > arr[i][j]){
                    curr_second_min = curr_first_min;
                    curr_first_min = arr[i][j];
                }else if(curr_second_min > arr[i][j]){
                    curr_second_min = arr[i][j];
                }
            }
            first_min =curr_first_min;
            second_min = curr_second_min; 
        }
        
        
        int result =INT_MAX;
        for(int j=0;j<cols;j++){
            result = min(result, arr[rows-1][j]);
        }
        
        return result;
        
    }
};
