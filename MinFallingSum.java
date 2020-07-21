// Time Complexity :O(n*m) n*m = all the elements in the matrix.
// Space Complexity : O(1) csince using the original array to store updated values.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  //yes dp.

// Your code here along with comments explaining your approach
  //simillar to paint house problem,
  //strting from row 1 to last row in matrix,
  //in each row update the value of the elem based on value of elem+
  //min (A[i-1][j], A[i-1][j+1], A[i-1][j-1]).
  //then from last row get min value.
class Solution {
    public int minFallingPathSum(int[][] A) {
        int len = A[0].length;
        //not using memo array[][].
        //instead made changes in place in A itself.
        for(int i = 1 ; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                A[i][j] = A[i][j]+Math.min(A[i-1][j],
Math.min(j==0?Integer.MAX_VALUE:A[i-1][j-1], j==len-1?Integer.MAX_VALUE:A[i-1][j+1])) ;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int num: A[len-1])
            min = min > num?num:min;
        return min;
    }
}
