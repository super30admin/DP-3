// Time Complexity : O(N^2)
// Space Complexity : O(N^2)	where N & M are rows and columns of the matrix N = M
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if(A.length == 0 || A == null){		// Base Case
            return 0;
        }
        
        if(A.length == 1){					// if there's only 1 element
            return A[0][0];
        }
        
        for(int i = 1; i<A.length; i++){			// traverse through the rows
            for(int j = 0; j<A[0].length;j++){		// traverse through the columns
                if(j == 0){							// considering the edges of the matrix, i.e 0th index
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                }
                if(j == A[0].length - 1){			// considering the edges of the matrix, i.e Nth index
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                }
                if( j > 0 && j < A[0].length - 1){		// middle columns have to compared with previous 3 other columns 
                    A[i][j] += Math.min(Math.min(A[i-1][j], A[i-1][j-1]), A[i-1][j+1]);
                }
            }
        }
        int i = A.length - 1;
        int min = 9999;
        for(int j = 0; j < A.length-1; j++){			// finding the minimum of the last row 
            int temp = Math.min(A[i][j],A[i][j+1]);
            if(temp < min){
                min = temp;
            }
        }
        return min;									// return the minimum possible path sum
    }
}