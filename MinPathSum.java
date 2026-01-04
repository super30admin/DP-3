// Time Complexity : O(n*n)
// Space Complexity : O(1) using same matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We iterate over the matrix, and search for min at each stage
// at each index, we find min from prev row col-1, col, col+1
// add that to current index, and continue
// return min of last row
class MinpathSum {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        //iterate over matrix
        for(int i = 1;i<len;i++)
        {
            for(int j = 0;j<len;j++)
            {
                //calculate left, top, right of prev row
                int left = (j==0)?0:matrix[i-1][j-1];
                int top = matrix[i-1][j];
                int right = (j==len-1)?0:matrix[i-1][j+1];

                //add this min to current index
                if(j==0)
                {
                    int min = Math.min(top,right);
                    matrix[i][j]+=min;
                }
                else if(j==len-1)
                {
                    int min = Math.min(top,left);
                    matrix[i][j]+=min;
                }
                else
                {
                    int min = Math.min(top,Math.min(left,right));
                    matrix[i][j]+=min;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        //return min of last row
        for(int i= 0;i<len;i++)
        {
            min = Math.min(matrix[len-1][i],min);
        }
        return min;
    }
}