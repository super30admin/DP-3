//Time: O(n*n), Space: O(1)
//Runs on leetcode solution accepted
var minFallingPathSum = function(matrix) {
    if(matrix.length == 0 ) return 0;
    let n = matrix.length;
    for(let i=n-2;i>=0;i--){
        for(let j=0;j<n;j++){
            if(j==0){
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1] )
            }else if(j == n-1){
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1] )
            }else{
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]) )
            }
        }
    }
    let min = matrix[0][0]
    
    for(let i=1;i<n;i++){
        min = Math.min(min,matrix[0][i])
    }
    return min
};