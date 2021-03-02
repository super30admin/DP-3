// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){return -99999;}
        int n = matrix.length;
        int m = matrix[0].length;
        if(n!=m)
        {return -99999;}
        for(int r = n-2;r>=0;r--){
            for(int c = 0;c<n;c++){
                int minVal = matrix[r+1][c];
                if(c>0)
                    minVal = Math.min(minVal, matrix[r+1][c-1]);
                if(c+1<n)
                    minVal = Math.min(minVal, matrix[r+1][c+1]);
                matrix[r][c] += minVal;
                }
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(matrix[i][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int x:matrix[0]){
            ans = Math.min(ans,x);
            System.out.println(x);}
        return ans;
        }
        
    
}