// Time Complexity : O (n)^2 where n*n is the matrix size
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
  if (matrix.length === 0 || matrix === null) {
    return 0;
  }

  var n = matrix.length;

  for (var i = n - 2; i >= 0; i--) {
    for (var j = 0; j < n; j++) {
      //Edge cases : Corner elements
      if (j === 0) {
        matrix[i][j] =
          matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
      } else if (j === n - 1) {
        matrix[i][j] =
          matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
      } else {
        matrix[i][j] =
          matrix[i][j] +
          Math.min(
            matrix[i + 1][j + 1],
            Math.min(matrix[i + 1][j - 1], matrix[i + 1][j])
          );
      }
    }
  }
  var min = Number.MAX_VALUE;

  for (var j = 0; j < n; j++) {
    min = Math.min(min, matrix[0][j]);
  }

  return min;
};
