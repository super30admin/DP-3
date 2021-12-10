// Time Complexity :O(mn) m=number of rows,n-number of columns
// Space Complexity :O(1) didnt use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution2 {

    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return -1;
        int n=matrix.length;
         int m=matrix[0].length;
        int min=Integer.MAX_VALUE;
        // adding up all minimum from the neighbours and moving up
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<m;j++){
                    if(j==0){
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                    }
                    else if(j==m-1){
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                    }
                    else{
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));
                    }
                }
            }
          for(int j=0;j<m;j++){
              min=Math.min(min,matrix[0][j]);
          }
        
        return min;
        }
    
}
