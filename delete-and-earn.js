// Time Complexity : O(NlgN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I couldn't figure it out so I read the discussion/solution to understand it.  Still need the class tomorrow to get the concept.

/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    // Instantiate an array
    // of length 10001 (max input size) and fill it with 0
    const count = new Array(10001).fill(0);
    let curr = 0,
        avoid = 0,
        prev = -1;

    // Set the count of each number that occurs in the input
    // in our count array
    for (const num of nums) {
        count[num]++;
    }

    for (let i = 0; i < 10000; i++) {
        // If we are looking at a value of i not in count
        // continue
        if (count[i] <= 0) continue;

        // Else let m be the max of avoid and the curr number
        let m = Math.max(avoid, curr);

        if (i - 1 != prev) {
            // If the i - 1 isn't the last number let curr be the count of i + our m
            curr = i * count[i] + m;
        } else {
            // Else set the curr to the count of i + avoid
            curr = i * count[i] + avoid;
        }
        avoid = m;
        prev = i;
    }

    // Return the max value
    return Math.max(avoid, curr);
};
