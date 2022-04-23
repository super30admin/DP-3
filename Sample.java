// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// class Solution {
    
//     //TC O(Max(nums or Max+1))
//     //SC O(n) which is max+1
//     public int deleteAndEarn(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         int n = nums.length;
//         int max=0;
//         for(int num : nums){
//                if(max<num){
//                    max= num;
//                } 
//             }
//         int[] newnums = new int[max+1];
        
//             for(int num : nums){
//                newnums[num] += num;}
        
//         int[][] dp = new int[max+1][2]; 
            
//             dp[0][1] = newnums[0];
        
//         for(int i = 1; i < max+1; i++){
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
//             dp[i][1] = newnums[i] + dp[i-1][0];
//         }
//        return Math.max(dp[max][0], dp[max][1]);
//     }
// }

// class Solution {
    
//     //TC O(n*n) SC O(1)
//     public int minFallingPathSum(int[][] matrix) {
//         if(matrix == null || matrix.length ==0) return 0;
//         int n = matrix.length;
//         for(int i =n-2; i>=0; i--){
//             for(int j = 0; j<n;j++){
//                 if(j ==0){
//                     matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                    
//                 } else if(j==n-1){
                    
//                     matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                    
//                 } else{
//                     matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                    
//                 }
                
//             }
            
//         }
//     int min = Integer.MAX_VALUE;
//     for(int j =0; j<n; j++){
     
        
//             min = Math.min(min, matrix[0][j]);
        
             
//     }return min;
    
//     }
// }
