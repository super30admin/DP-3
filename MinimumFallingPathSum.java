// Time Complexity : O(MN)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// "static void main" must be defined in a public class.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //if only one subarray
        if(matrix.length == 1) return matrix[0][0];
        int N = matrix.length;
        int[] arr = new int[N];
        //copying values from last row
        for(int j=0;j<N;j++) {
            arr[j] = matrix[N-1][j];
        }
        int curr = 0;
        int prev = 0;
        int min = Integer.MAX_VALUE;
        for(int i=N-2;i>=0;i--) {
            for(int j=0;j<N;j++) {
                //incase of first index, we got two possiblity, below or diagonally right
                if(j == 0) {
                    curr = arr[j];
                    arr[j] = matrix[i][j]+Math.min(arr[j], arr[j+1]);
                    prev = curr;

                } else if(j==N-1) {
                    //incase of last index, we got two possiblity, below or diagonally left
                    arr[j] = matrix[i][j]+Math.min(prev, arr[j]);
                } else {
                    //incase of middle index, we got three possiblities, below or diagonally left/right
                    curr = arr[j];
                    arr[j] = matrix[i][j]+Math.min( prev, Math.min(arr[j],arr[j+1]));
                    prev = curr;
                }
                if(i==0)
                    min = Math.min(min, arr[j]);
            }
        }
        return min;
    }
}