// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int left=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(j>0){
                    left=matrix[i][j]+matrix[i-1][j-1];
                }
                if(j<matrix.length-1){
                    right=matrix[i][j]+matrix[i-1][j+1];
                }
                int center=matrix[i-1][j]+matrix[i][j];
                matrix[i][j]=Math.min(center,Math.min(left,right));
            }
        }
        
        int result=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int row=matrix.length-1;
            result=Math.min(result,matrix[row][i]);
        }
        
        return result;
    }
}
