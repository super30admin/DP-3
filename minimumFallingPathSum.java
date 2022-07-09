// Time Complexity :O(m*n) where m are rows and n are columns
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public int minFallingPathSum(int[][] matrix) {
    if(matrix == null || matrix.length == 0) return 0;
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    for(int row = m-2;row>=0;row--){ // starting from bottom-1
        for(int col=0;col<n;col++){
            if(col == 0){
                matrix[row][col] += Math.min(matrix[row+1][col],matrix[row+1][col+1]);
            }else if(col == n-1){
                matrix[row][col] += Math.min(matrix[row+1][col],matrix[row+1][col-1]);
            }else{
                matrix[row][col] += Math.min(matrix[row+1][col],Math.min(matrix[row+1][col+1],matrix[row+1][col-1]));
            }
        }
    }
    int answer=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        answer = Math.min(answer,matrix[0][i]);
    }
    return answer;
}