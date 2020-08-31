// Time Complexity : O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int size = A[0].size();
        vector<int> nums(size, 0);
        vector<int> nums2(size, 0);
        nums = A[0];
      
        nums2 = A[0];
        if(size == 0){
            return 0;
        }
        
     
        for (int i = 1 ;i<size; i++) {
            for (int j = 0; j<size; j++){
                
                if (j == 0){
                   
                   nums[j]= A[i][j] + min(nums2[j], nums2[j+1]);
                }
                else if (j == size-1){
                   
                    nums[j]= A[i][j] +min(nums2[j], nums2[j-1]);
                   
                    
                }
                else{
                   nums[j] = A[i][j] +min(nums2[j-1],min(nums2[j], nums2[j+1])); 
                }
                
              
            }
            nums2 = nums;
        }
        int result = INT_MAX;
       for (int i = 0; i<size ; i++){
           
          if (nums[i] < result)
             
              result = nums[i];
       } 
        
        return result;
    }