// Time Complexity : O(m*n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] A) {
        
        if (A.length == 0) return 0;   

        int r = A.length;
        int c = A[0].length;
        
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < r; i++) {
            
            for(int j=0;j<c;j++) {
                
                // Min cost of falling to A[i][j] from top row will be min of [A(i-1,j-1),A(i-1,j),A(i-1,j+1)] + A[i][j]
                //initial set min cost to element above as it will always exist
                int min = A[i - 1][j];

                // if j>0 compare min to j-1 and i-1 element
                if(j>0)
                    min = Math.min(min, A[i - 1][j-1]);

                // if j<c-1 compare min to j+1 and i-1 element
                if(j<c-1)
                    min = Math.min(min, A[i - 1][j+1]);
                
                //set A[i][j] to include prev row min
                A[i][j] += min;
                
                //if last row calculate final ans 
                if(i==c-1) {
                    if(A[i][j]<ans) ans = A[i][j];
                }
                
            }
        }


        //return min from last row 
        return ans==Integer.MAX_VALUE?A[0][0]:ans;
    }
}
