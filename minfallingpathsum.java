//time complexity is O(m*n)
//space complexity is O(1)
//able to submit in leetcode
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        if(matrix.length==1){
            int[] arr = matrix[0];
            Arrays.sort(arr);
            return arr[0];
        }
        if(matrix[0].length==1){
            int[] arr= matrix[0];
            Arrays.sort(arr);
            return arr[0];
        }
        for(int i=1;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }
                else if(j==(matrix.length-1)){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }
                else {
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
                }
                if(i==(matrix.length-1)){
                    result = Math.min(result, matrix[i][j]);
                }
            }
        }
       
        return result;
    }
}

