// Time Complexity : O(n*m) n - # of rows, m- # of cols in given matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length == 0) return 0;
        int n = matrix.length,m=matrix[0].length;
       // add the previous rows adjacent values as a cumulative sum and find the min of last row
      // this gives the sum of path with minimum sum from 0 to n rows
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j == 0) matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j == m-1) matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                else matrix[i][j] += Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
            }
        }
        int res =Integer.MAX_VALUE;
        for(int s:matrix[n-1])
            res = Math.min(s,res);
        return res;
    }
}
