// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

var minFallingPathSum = function(A) {
    for (let i = A.length - 2; i >= 0; i -= 1) {
        for (let j = 0; j < A[i].length; j += 1) {
            A[i][j] += Math.min(getValueOrInfinity(A, i + 1, j - 1), getValueOrInfinity(A, i + 1, j), getValueOrInfinity(A, i + 1, j + 1));
        }
    }
    return A[0].reduce((a, b) => Math.min(a, b));
};

function getValueOrInfinity(A, i, j) {
    return A[i][j] !== undefined ? A[i][j] : Infinity;
}