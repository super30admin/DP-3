// Time Complexity : O(n^2)
// Space Complexity : O(n)
    // n is the number of rows or columns

// Your code here along with comments explaining your approach
    //Here we maintain an array to keep a track of all the least sums possible if each of the previous row numbers are considered to be in the path.
    //In each row, while iterating over the indexes, We find the minimum of previous row adjacent indexes and current index. We add the minimum to the current index.
    //After traversing the last row, the answer is the minimum of all the sums stored in the additional array.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prevRow = new int[n];
        prevRow = matrix[0];
        int[] currentRow = new int[n];
        for (int i=1; i<n; i++)
        {
            currentRow = matrix[i];
            for (int j=0; j<n; j++)
            {
                int min = Integer.MAX_VALUE;
                if (j-1>=0)
                {
                    min = Math.min(min, prevRow[j-1]);
                }
                min = Math.min(min, prevRow[j]);
                if (j+1<n)
                {
                    min = Math.min(min, prevRow[j+1]);
                }
                currentRow[j] += min;
            }
            prevRow = currentRow;
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<n; i++)
        {
            ans = Math.min(ans, prevRow[i]);
        }
        return ans;
    }
}