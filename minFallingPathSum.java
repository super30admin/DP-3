// Time Complexity : O(MN) but since its a square matrix we can write it as O(N^2)
// Space Complexity : O(1) Since we are not taking any extra space and just mutating the same array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//If there is any problem which requires maximization or minimization we use the greedy approach

// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        //Start from 2nd row
        for(int i = 1; i<A.length; i++){
            for(int j = 0; j<A[0].length; j++){
                if(j==0){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }
                //reached the last column
                else if(j == A[0].length -1){
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }
                //consider j-1/j/j+1
                else{
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j+1],A[i-1][j-1]));
                }
            }
        }
        //Get the elements from the last row and return the minmum
        int min = Integer.MAX_VALUE;
        for(int num: A[A.length-1]){
            min = Math.min(min,num);
        }
        return min;
    }
}