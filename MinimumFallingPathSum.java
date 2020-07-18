//Approach the problem similar to PaintHouse we add the min found in each row and add it to the last row
//This solution O(n*n) where is n is the lenght of Array and the space complexity is O(1)

class Solution {
  public int minFallingPathSum(int[][] A) {
    if(A.length == 0)
      return 0;
    int n = A.length;
    for(int i=1;i<n;i++){
      for(int j=0;j<n;j++){
        int min = A[i-1][j];
        if (j > 0) {
          min = Math.min(min, A[i-1][j-1]);
        }
        if (j < n-1) {
          min = Math.min(min, A[i-1][j+1]);
        }
        A[i][j] += min;
      }
    }
    int minVal = Integer.MAX_VALUE;
    for (int x: A[n-1])
      minVal = Math.min(minVal, x);
    return minVal;
  }
}