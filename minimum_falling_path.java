// Time Complexity : O(n * m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public int minFallingPathSum(int[][] matrix) {
    if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
        return 0;
    
    int n = matrix.length;
    int m = matrix[0].length;
    
    //we dont start from the first row as we have to generate all the subtrees. This approach will closely
    //mimic the brute force approach
    for(int i = 1; i < n; i++){
        for(int j = 0; j < m; j++){
            //check for left boundary elements. They can map to only two elements.
            if(j == 0){
                matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
            }
            ///check for right boundary elements. They can map to only two elements.
            else if(j == m - 1){
                matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j-1]);
            }
            //The rest of the elements have to choose from the 3 value that they can be mapped to.
            else{
                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i-1][j+1]));
            }
        }
    }
    
    int min = Integer.MAX_VALUE;
    //function to check the minimum value which will be the minimum value in  the last row
    for(int x : matrix[n - 1]){
        if(x < min){
            min = x;
        }
    }
    return min;
}