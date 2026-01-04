// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 *  Time Complexity : O(3^N) where N is the number of row
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int j=0;j<col;++j){
            min = Math.min(min,helper(matrix,0,j,dp));
        }
        
        return min;
    }
    int helper(int[][] matrix,int row,int col,int[][] dp){
       if(row==matrix.length-1){
          return matrix[row][col];
       } 
       int x,y,z;
       x=y=z = Integer.MAX_VALUE;
       if(isValid(col,matrix[row].length)){
           x = matrix[row][col]+helper(matrix,row+1,col,dp);
       } 
       if(isValid(col+1,matrix[row].length)){
           y = matrix[row][col]+helper(matrix,row+1,col+1,dp);
       }
       if(isValid(col-1,matrix[row].length)){
           z = matrix[row][col]+helper(matrix,row+1,col-1,dp);
       }
       return Math.min(x,Math.min(y,z));
    }
   boolean isValid(int i,int colwidth){
      return i>=0 && i<colwidth;
   }
}
/**
 * Recursion + Memoization
 *  Time Complexity : O(n*n) where n is the number of row and column
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[row][col];
        for(int[] rowArr : dp) {
             Arrays.fill(rowArr, Integer.MAX_VALUE);
        }
        for(int j=0;j<col;++j){
            min = Math.min(min,helper(matrix,0,j,dp));
        }
        
        return min;
    }
    int helper(int[][] matrix,int row,int col,int[][] dp){
       if(row==matrix.length-1){
          return matrix[row][col];
       } 
       int x,y,z;
       x=y=z = Integer.MAX_VALUE;
       if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
       if(isValid(col,matrix[row].length)){
           x = matrix[row][col]+helper(matrix,row+1,col,dp);
       } 
       if(isValid(col+1,matrix[row].length)){
           y = matrix[row][col]+helper(matrix,row+1,col+1,dp);
       }
       if(isValid(col-1,matrix[row].length)){
           z = matrix[row][col]+helper(matrix,row+1,col-1,dp);
       }
       dp[row][col] = Math.min(x,Math.min(y,z));
       return Math.min(x,Math.min(y,z));
    }
   boolean isValid(int i,int colwidth){
      return i>=0 && i<colwidth;
   }
}
/**
 *  Time Complexity : O(N+2^K) where n is number of elements in original array and K is the max element 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;++i){
            max = Math.max(nums[i],max);
        }
        int[] num = new int[max+1];
        for(int i=0;i<nums.length;++i){
            num[nums[i]]+= nums[i];
        }
        return helper(num,0,dp);
    }
    int helper(int[] num,int idx,int[] dp){
      // base
      if(idx>=num.length) return 0;
      // logic
      // not pick 
      int case1 = helper(num,idx+1,dp);
      // pick
      int case2 = num[idx]+helper(num,idx+2,dp);
      return Math.max(case1,case2);
    }
}

/**
 *  Time Complexity : O(N+K) where N is number of elements and K is maximum value
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;++i){
            max = Math.max(nums[i],max);
        }
        int[] num = new int[max+1];
        for(int i=0;i<nums.length;++i){
            num[nums[i]]+= nums[i];
        }
        int[] dp = new int[num.length];
        Arrays.fill(dp,-1);
        return helper(num,0,dp);
    }
    int helper(int[] num,int idx,int[] dp){
      // base
      if(idx>=num.length) return 0;
      if(dp[idx]!=-1) return dp[idx];
      // logic
      // not pick 
      int case1 = helper(num,idx+1,dp);
      // pick
      int case2 = num[idx]+helper(num,idx+2,dp);
      dp[idx] = Math.max(case1,case2);
      return Math.max(case1,case2);
    }
}
