// Time Complexity : O(n * m) where n and m are size num of rows and columns in the matrix
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Declare one arr variable which would store the min status of each cell in the previous row
//We can check upper left, right and middle position for the fall to current cell
//We will find the min of all the current row cells and store in cur array
//We will repeat this process till we reach the last row
//In the last row we will find the min and return this as answer
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int l = matrix[0].length;
        int[] arr = matrix[0];
        
        for(int i = 1; i < matrix.length; i++){
            int[] cur = new int[l];
            for(int j = 0; j < l; j++){
                
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int curCell = arr[j];
                if(j > 0)
                    left = arr[j-1];
                if(j < l - 1)
                    right = arr[j+1];
                cur[j] = matrix[i][j] + Math.min(left, Math.min(right, curCell));
            }
            arr = cur;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}