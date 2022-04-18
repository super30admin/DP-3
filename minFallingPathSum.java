//Time Complexity : O(nm)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //base case
        if(matrix==null)
            return -1;
        int n=matrix.length;
        int[][] k=new int[n][n];
        //filling the last row of the k matrix with elements of given matrix
        for(int i=0;i<n;i++){
            k[n-1][i]=matrix[n-1][i];
        }
        //from 2nd last row we will iterate through each row of the matrix and through the columns
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                //initialize the cost of the cell
                k[i][j]=matrix[i][j];
                int minValue=k[i+1][j];
                //checking the down right value
                if(j+1<n)
                    minValue=Math.min(minValue,k[i+1][j+1]);
                //checking the down left value
                if(j-1>=0)
                    minValue=Math.min(minValue,k[i+1][j-1]);
                //the min value will be added to the k matrix
                k[i][j]=k[i][j]+minValue;
            }
        }
        int minSum=Integer.MAX_VALUE;
        //iterating over the 1st row of the matrix which contains the min value will be returned
        for(int i=0;i<n;i++){
            minSum=Math.min(k[0][i],minSum);
        }
        return minSum;
    }
}