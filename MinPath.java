import java.util.*;

// Time Complexity : o(n*m); 2 single for loops and one double for loops
// should we write o(3n*m) or o(2n)* o(m*n) to be exact

// Space Complexity :o(m*n) array of height m and length n


// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : coming up with the formula and handling edge case
// to further optimize it -> it should be using the same 2d array or using a new single dimensional array


// Your code here along with comments explaining your approach
// 1. filling the first row 
// 2. starting from second row ->comparing and taking results from first and adding it to second. 
// 3. finally returning min from the last row.

class MinPath {
      public static int minPathFalling(int[][] grid) {
          int m = grid.length; int n = grid[0].length;
          int [][]dp = new int[m][n];
          for(int i=0;i<n;i++){
              dp[0][i] = grid[0][i];
          }
          for(int i=1;i<m;i++){
              for(int j=0;j<n;j++){
                  if(j==0){
                      dp[i][j]= grid[i][j]+ Math.min(dp[i-1][j],dp[i-1][j+1]);
                  }else if(j==n-1){
                         dp[i][j]= grid[i][j]+ Math.min(dp[i-1][j],dp[i-1][j-1]);
                  }else{
                      dp[i][j]= grid[i][j] + Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
                  }
              }
          }
          int min = Integer.MAX_VALUE;
          for(int i=0;i<n;i++){
              if(min>dp[m-1][i]){
                  min = dp[m-1][i];
              }
          }
          return min;
          
    }
  
	public static void main (String[] args) {
	  int grid[][] = {{1,2,3},{4,5,6},{7,8,9}};
	  
		System.out.println(minPathFalling(grid));
		
	}
}