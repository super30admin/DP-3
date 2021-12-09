// Time Complexity : O(n)
// Space Complexity : O(n) because we declare a new dp array
// who's size will be the same as the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var deleteAndEarn = function (nums) {
  let maxValueInArr = nums[0];

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] > maxValueInArr) {
      maxValueInArr = nums[i];
    }
  }

  const dpArr = new Array(maxValueInArr + 1).fill(0);

  for (let i = 0; i < nums.length; i++) {
    if (dpArr[nums[i]] === undefined) {
      dpArr[nums[i]] = nums[i];
    } else {
      dpArr[nums[i]] += nums[i];
    }
  }

  for (let i = 2; i < dpArr.length; i++) {
    dpArr[i] = Math.max(dpArr[i - 2] + dpArr[i], dpArr[i - 1]);
  }
  console.log(dpArr);
  return dpArr[dpArr.length - 1];
};

console.log(deleteAndEarn([2, 2, 3, 3, 3, 4, 6]));
