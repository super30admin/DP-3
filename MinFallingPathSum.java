/*
Author: Akhilesh Borgaonkar
Problem: LC 931. Minimum Falling Path Sum (DP-3)
Approach: Using Dynamic Programming approach here to find the minimum sum based on previous minimum sums in the given matrix. 
Time Complexity: O(n^2) where n is length of given square matrix.
Space complexity: O(1) constant because not using extra space and mutating input matrix.
*/

class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                
                int minFromUp = 0;
                if(j==0)
                    minFromUp = Math.min(A[i-1][j],A[i-1][j+1]);        //if current index is in first column then pick the min of above and above-right
                else if(j==(n-1))
                    minFromUp = Math.min(A[i-1][j], A[i-1][j-1]);       //if current index is in last column then pick the min of above and above-left
                else
                    minFromUp = Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));    //else pick min of above-left, above and above-right
                
                A[i][j] += minFromUp;               //mutate the input matrix
            }
        }
        
        int min = A[n-1][0];
        for (int i = 1; i < n; i++)             //picking the minimum from last row
            min = Math.min(min, A[n-1][i]);
        return min;
    }
}