// # DP-3

// Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


var minFallingPathSum = function(matrix){
    //Time Complexity: O(m × n)
    //Space Complexity: O(m × n)
    let n = matrix.length
    let m = matrix[0].length
    let dp= Array.from({length:matrix.length},()=> new Array(matrix[0].length).fill(0))

    for(let j = 0;j<m;j++){
        dp[n-1][j] = matrix[n-1][j]
    }
    for(let i=n-2;i>=0;i--){
        for(let j = 0;j<m;j++){
            let downleft = j-1<0?Infinity:dp[i+1][j-1]
            let down = dp[i+1][j]
            let downRight = j+1>=m?Infinity:dp[i+1][j+1]
             dp[i][j] = matrix[i][j] + Math.min(downleft, down, downRight);

        }
    }
    return Math.min(...dp[0])
}

// var minFallingPathSum = function(matrix) {
//     let n = matrix.length;
//     let m = matrix[0].length;

//     let prev = [...matrix[n - 1]]; // last row of matrix

//     for (let i = n - 2; i >= 0; i--) {
//         let curr = new Array(m).fill(0);
//         for (let j = 0; j < m; j++) {
//             let downLeft = j - 1 >= 0 ? prev[j - 1] : Infinity;
//             let down = prev[j];
//             let downRight = j + 1 < m ? prev[j + 1] : Infinity;
//             curr[j] = matrix[i][j] + Math.min(downLeft, down, downRight);
//         }
//         prev = curr;
//     }

//     return Math.min(...prev);
// }


// var minFallingPathSum = function(matrix) {
//     //**Time Complexity : O(m*3^n) */
//     //**Space Complexity : O(n) */
//     let min = Infinity
//     for(let j=0;j<matrix[0].length;j++){
//         min = Math.min(min,helper(0,j))
//     }
//     return min
//     function helper(i,j){
//         //Base
//         //for j
//         //when J goes out of bounds
//         if(j < 0 || j>=matrix[0].length) return Infinity
//         //Reached at the last row of matrix
//         if(i == matrix.length-1) return matrix[i][j] 
//         //Logic // Choose not choose
//         return matrix[i][j] + Math.min(helper(i+1,j-1),helper(i+1,j),helper(i+1,j+1))
//     }
// };
