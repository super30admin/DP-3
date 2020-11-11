/*
Time Complexity :O(n*n)= O(n^2)- Need to traverse entire square array
Space Complexity :I think its O(n), as i am just using dp array to store values for minimm falling path
Did this code successfully run on Leetcode : Yes
Output from Leetcode: "Runtime: 3 ms, faster than 88.69% of Java online submissions for Minimum Falling Path Sum.
Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Minimum Falling Path Sum.
"

Any problem you faced while coding this : As this problem was discussed in class, it ran succesfully 
in first attempt


Your code here along with comments explaining your approach

*/
import java.util.*;
import java.io.*;

public class Problem2_LC_931_MinimumFallingPathSum {
	 public static int minFallingPathSum(int[][] A) {
	        int len= A.length;
	        if(len==0) return 0;
	        if (len == 1) return A[0][0];
	       
	        int[][] dp = new int[len][len];
	        int res= Integer.MAX_VALUE;
	        //Copy first row of A in dp 
	        for(int i=0;i<len;i++){
	            dp[0][i]= A[0][i];
	        }
	      
	        //Compute minimum values for current row based on all the combinations from prev row.
	        //Prev row contains best possible minimum path values
	        for(int i=1; i<len; i++){
	            for(int j=0; j<len; j++){
	                //If its leftmost element of array
	                if(j==0)
	                    dp[i][j]= Math.min(dp[i-1][j],dp[i-1][j+1]) + A[i][j];
	                //If its rightmost element of array
	                else if(j== len-1)
	                    dp[i][j]= Math.min(dp[i-1][j-1],dp[i-1][j]) + A[i][j];
	                //For others
	                else
	                    dp[i][j]= Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i-1][j+1])) + A[i][j];
	                if(i==len-1) 
	                    res= Math.min(res, dp[i][j]);
	            }
	        }
	        return res;
	        
	    }
	 public static void main(String[] args) {
		 int[][] Input= {{1,2,3},{4,5,6},{7,8,9}};
		 
		 System.out.println("The possible falling path is:  "+ minFallingPathSum(Input));
	 }

}
