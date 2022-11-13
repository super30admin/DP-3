// Time Complexity : O(n)+O(m) where n is length of array and m is the max element in array
// Space Complexity : O (m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
  if (nums.length === 0 || nums === null) {
    return 0;
  }
  var max = Number.MIN_VALUE;

  for (var i in nums) {
    max = Math.max(max, nums[i]);
  }

  var n = nums.length;
  var dp = new Array(max + 1);
  dp.fill(0);
  for (var i = 0; i < n; i++) {
    var index = nums[i];
    dp[index] = dp[index] + nums[i];
  }

  var skip = 0,
    take = dp[0];

  for (var i = 1; i < dp.length; i++) {
    var temp = skip;
    skip = Math.max(take, skip);
    take = temp + dp[i];
  }

  return Math.max(skip, take);

  // console.log(dp, max)
};
