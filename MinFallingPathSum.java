//Time Complexity :O(n)
//Space Complexity:O(1)
//Microsoft Interview
//Greedy Approach :for first row it check from start first col element 2+5+7=14
//2.col 1+4+7=12
//3.col 3+4+8=15 but this approach fails for other case

//Exhaustive approach:Using same Array we can reuse fro multiple time so here space complexity is constant .row incresing order = i_+1 and colum increasing order =j+1
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;//row;
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(j==0){
                        matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                    } else if(j==n-1){
                      matrix[i][j] += Math.min(matrix[i+1][j],matrix[i+1][j-1]);  
                    }else {
                        matrix[i][j] += Math.min(matrix[i+1][j],Math.min(matrix[i+1][j+1],matrix[i+1][j-1]));
                    }
                }
             }
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min = Math.min(min,matrix[0][j]);
            }
            return min;
    }
}