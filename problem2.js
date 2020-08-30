//// Time Complexity : O(n^2)
//// Space Complexity : O(1) but i do overwrite the input array, O(NxL) if i copy the input array, N rows of length L
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :
//  tried to implement 1 row extra space solution but got confused
//  overwriting the input array was simpler

//// Your code here along with comments explaining your approach

// this is like the house painting problem
// foreach row in your array (starting at row 1 not row 0)
//   pick the minimum value at each column where
//   minvalue = (
//     if you are far left, min = min(directly above, and above right)
//     if you are far right, min = min(directly above, and above left)
//     else you have left and right, min = min(above, above left, above right)

// return the minimum of the last row
var minFallingPathSum;

minFallingPathSum = function(A) {
  var coli, i, j, ref, ref1, rowi;
  if (A === null || A.length === 0 || A[0].length === 0) {
    return -1;
  }
  if (A.length === 1 && A[0].length === 1) {
    return A[[0]];
  }
  for (rowi = i = 1, ref = A.length - 1; (1 <= ref ? i <= ref : i >= ref); rowi = 1 <= ref ? ++i : --i) {
    for (coli = j = 0, ref1 = A[0].length - 1; (0 <= ref1 ? j <= ref1 : j >= ref1); coli = 0 <= ref1 ? ++j : --j) {
      if (coli === 0) {
        A[rowi][coli] += Math.min(A[rowi - 1][coli], A[rowi - 1][coli + 1]);
      } else if (coli === A[0].length - 1) {
        A[rowi][coli] += Math.min(A[rowi - 1][coli], A[rowi - 1][coli - 1]);
      } else {
        A[rowi][coli] += Math.min(A[rowi - 1][coli], A[rowi - 1][coli - 1], A[rowi - 1][coli + 1]);
      }
    }
  }
  return A[A.length - 1].reduce(function(acc, val) {
    if (acc > val) {
      return val;
    } else {
      return acc;
    }
  }, Number.MAX_SAFE_INTEGER);
};

//minFallingPathSum([[69]]);
//minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])

//# sourceMappingURL=problem2.js.map
