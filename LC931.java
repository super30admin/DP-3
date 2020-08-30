
// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        //if the matrix is empty, return 0
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        
        //we start iterating from the first row so we know the previous row and we can choose the minimum value from the options we have
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                //We have three cases:
                //when index is at the first element
                if(j == 0){
                    //We have two options to choose min from
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                //When index is at the last element in the row
                
                else if(j == A.length - 1){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }
                //When index is somewhere in the middle
                else{
                    //In this case, we have three options to choose min from
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        
    
        int min = Integer.MAX_VALUE;
        
        //iterate over the last row to find the minimum value and return it
        for(int num : A[A.length - 1]){
            if(num < min){
                min = num;
            }
        }
        
        return min;
    }
}