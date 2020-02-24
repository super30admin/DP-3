/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//The minimum path has to be calculated such that the path followed is 

//DP solution is O(n^2) and if dp table is used  the space complexity is O(n^2) or else if only row calculations are used
// the space complexity would be O(1);
public class Min_falling_path1 {

public static int minFallingPathSumOptimized(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        if(A == null || A.length == 0){return 0;}
        
        int result = Integer.MAX_VALUE;
        
       
        for(int i=1;i<m;i++){
            
            for(int j=0;j<n;j++){
                
             if(j==0){A[i][j] =A[i][j] +  Math.min(A[i-1][j],A[i-1][j+1]);}//Check upper and the col ahead of  it 
                else if(j==n-1){A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);}// check upper and col before it.
                
                 else
                {
                    A[i][j] = A[i][j]+ Math.min(Math.min(A[i-1][j],A[i-1][j+1]),A[i-1][j-1]);//Check upper before and after cols.
                }
 
            }
        }
        
         for(int j=0;j<n;j++){
                    
                    result = Math.min(result,A[m-1][j]);// Find min in the last row.
                }
        
        return result;
    }
	
	
	
public static int minFallingPathSum(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        if(A == null || A.length == 0){return 0;}
        
        int result = Integer.MAX_VALUE;
        
        for(int j=0;j<n;j++){
            dp[0][j] = A[0][j];
        }
        
        for(int i=1;i<m;i++){
            
            for(int j=0;j<n;j++){
                
             if(j==0){dp[i][j] =A[i][j] +  Math.min(dp[i-1][j],dp[i-1][j+1]);}// Check the same and the column ahead
                else if(j==n-1){dp[i][j] = A[i][j] + Math.min(dp[i-1][j],dp[i-1][j-1]);}//Check the same column and back column
                
                 else
                {
                    dp[i][j] = A[i][j]+ Math.min(Math.min(dp[i-1][j],dp[i-1][j+1]),dp[i-1][j-1]); //Check the above row and same and front and back column
                }
 
            }
        }
        
         for(int j=0;j<n;j++){
                    
                    result = Math.min(result,dp[m-1][j]);// Find min in the last row.
                }
        
        return result;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int minimum_amount = minFallingPathSum(arr);
		int minimum_amount2 = minFallingPathSumOptimized(arr);
		System.out.println(minimum_amount);
		System.out.println(minimum_amount2);
	}

}
