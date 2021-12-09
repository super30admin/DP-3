// Time Complexity :O(n*m)
// Space Complexity :O(1); since we are altering the given input array.
// Did this code successfully run on Leetcode :yes
/*Bottom up Approach -
element from position (row, col) will be minimum of (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length==0||matrix==null)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0)
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                else if(j==n-1)
                        matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                else
                matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));

            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min= Math.min(min,matrix[0][i]);
        }
        return min;
    }
}