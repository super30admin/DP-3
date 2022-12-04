// Time Complexity : O(n^2)
// Space Complexity : O(1)

//https://leetcode.com/problems/minimum-falling-path-sum
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int minValue ;
                if(j==0 ){
                    minValue = Math.min(matrix[i+1][j],matrix[i+1][j+1]); 
                }else if(j==n-1){
                    minValue = Math.min(matrix[i+1][j],matrix[i+1][j-1]); 
                }else{
                    minValue = Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1])); 
                }
                matrix[i][j] = matrix[i][j] + minValue;
            }
        }
        min=matrix[0][0];
        for(int i=1;i<n;i++){
            min = min>matrix[0][i] ? matrix[0][i] : min;
        }
        return min;
    }
}
