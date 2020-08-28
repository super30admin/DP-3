// Time Complexity : O(N x M) where N is the rows and M is the columns in 'A'.
// Space Complexity : O(1) since we are using the input Array.
//                     Otherwise we would use one 1D array of size M (coulmns) - O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not really. Was similar to house paint problem.

public class FallingPath {
        public int minFallingPathSum(int[][] A) {
            //if A is of size 0, return 0 as minimum path sum.
            if(A.length == 0) {
                return 0;
            }
            
            for(int i = 1 ; i < A.length ; i++) {
                for(int j = 0 ; j < A[0].length ; j++) {
                    int min = Integer.MAX_VALUE;
                    //for each element, find the minimum of the three top elements.
                    
                    if(j-1 >= 0 && A[i-1][j-1] < min) {
                        min = A[i-1][j-1];
                    }
                    
                    if(A[i-1][j] < min) {
                        min = A[i-1][j];
                    }
                    
                    if(j+1 < A[0].length && A[i-1][j+1] < min) {
                        min = A[i-1][j+1];
                    }

                    //add it to current min.
                    A[i][j] += min;
                }
            }
            
            //final min is the minimum in the last row.
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < A[0].length; i++) {
                if(A[A.length-1][i] < min) {
                    min = A[A.length-1][i];
                }
            }

            //return min;
            return min;
        }
}