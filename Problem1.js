//Delete and Earn (LC 740)

// Time Complexity : O(n*O(max K))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes I didn't think of this DP approach till after Dominic mentioned how this is similar to House Robber

//Use DP I can make a simple array and then loop through and get the max

/**
 * 
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    if(nums.length === 0 || nums === null){
        return 0;
    }
    let table = new Array(Math.max(...nums)+1);
    table.fill(0);
    for(let num of nums){
        table[num] += num;
    }
    let prevSkip = 0;
    let prevAdd = 0;
    for(let i=1;i<table.length;i++){
        let temp = prevSkip;
        prevSkip = Math.max(prevSkip,prevAdd);
        prevAdd = table[i] + temp;
    }
    return Math.max(prevSkip, prevAdd);
};