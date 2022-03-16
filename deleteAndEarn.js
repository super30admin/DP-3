// Time Complexity : O(n) + O(m) where n is length of nums and m is length of max in the array
// Space Complexity : O(m) where m is the length of new array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    let length = Math.max(...nums); //O(n)
    let newArray = new Array(length+1).fill(0);
    for(let i=0; i<nums.length; i++) {
        newArray[nums[i]] += nums[i];
    }
    console.log(newArray);
    let skip = 0;
    let take = 0;
    for(let i=1; i<newArray.length; i++) { //O(m)
        let temp = skip;
        skip = Math.max(skip,take);
        take = temp + newArray[i];
    }
    return Math.max(skip,take);
};