// Time complexity : O(m)+O(max value in array)
// Space complexity: O(max value in array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out how to pre process the data and storing it at array's index


// Your code here along with comments explaining your approach
var deleteNeighbors = (arr, num, index) => {
    let a = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] !== num - 1 && arr[i] !== num + 1 && i !== index) {
            a.push(arr[i]);
        }
    }
    return a;
}
var helper = (arr, index, sum) => {
    // Base case
    if (arr.length === 0 || index >= arr.length) {
        return sum;
    }
    // Case 1 : Remove number
    let target = arr[index];
    let updatedArr = deleteNeighbors(arr, target, index);
    let case1 = helper(updatedArr, 0, sum + target);

    // Case 2 : Keep number
    let case2 = helper(arr, index + 1, sum);
    return Math.max(case1, case2);
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function (nums) {
    if (nums === null || nums.length === 0)
        return 0;

    // Recursive solution -> Time limit exceed
    // return helper(nums, 0, 0);

    // Iterate over nums to get the max value it contains
    let max = 0;
    for (let i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
    }
    // Create an array of length max+1 and fill with 0
    let sumArr = new Array(max + 1);
    sumArr.fill(0);
    // Store sum at number's index
    for (let i = 0; i < nums.length; i++) {
        let number = nums[i];
        sumArr[number] += number;
    }
    let skip = 0;
    let take = dp[0];
    for (let i = 0; i < sumArr.length; i++) {
        let temp = skip;
        skip = Math.max(skip, take);
        take = sumArr[i] + temp;
    }
    return Math.max(skip, take);
};
