////https://leetcode.com/problems/delete-and-earn/
//// Time Complexity : O(n)
//// Space Complexity : O(n) for the array copy
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
//  off by 1 in the array length
//  remembering house robber

//// Your code here along with comments explaining your approach

// two problems exist:
//  (1) finding the numbers immediately to the left and right of a number
//  (2) how to turn this into a dp choose / don't choose scenario

// to address both of these the algorithm will

// - linearly walk through input storing numbers into a 2nd array
// - second array will have at each index a sum of the numbers corresponding to that index
// - at each step you can either choose or not choose a number
// - this reduces the algorithm to a house robber scenario
var deleteAndEarn, max;

max = function(nums) {
  return nums.reduce(function(acc, num) {
    if (acc > num) {
      return acc;
    } else {
      return num;
    }
  }, Number.MIN_SAFE_INTEGER);
};

deleteAndEarn = function(nums) {
  var C, DC, i, j, len, len1, num, sumArray, temp;
  if (nums === null || nums.length < 1) {
    return 0;
  }
  // create an array [0..max(nums)] to hold sums
  sumArray = Array(max(nums) + 1).fill(0);
// store the sums
  for (i = 0, len = nums.length; i < len; i++) {
    num = nums[i];
    sumArray[num] += num;
  }
  // do house robber
  // - calculate a choose and a don't choose at each step
  //   dont_choose = max of(prev choose, prev dont_choose)
  //   choose = dc + current
  // - return the max after the last calculation
  C = 0;
  DC = 0;
  for (j = 0, len1 = sumArray.length; j < len1; j++) {
    num = sumArray[j];
    temp = DC;
    DC = Math.max(C, DC);
    C = temp + num;
  }
  return Math.max(C, DC);
};

//# sourceMappingURL=problem1.js.map
