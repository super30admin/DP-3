// Time Complexity : O(n + max(arr)) 
// Space Complexity : O(max(arr))
// Did this code successfully run on Leetcode : Yes


var deleteAndEarn = function (nums) {
    if (nums.length === 0 || !nums) return 0;
    let dp = [];
    let max = -Infinity;
    for (let i of nums) {
        max = Math.max(i, max);
    }
    var arr = new Array(max + 1).fill(0);
    for (let num of nums) {
        arr[num] += num;
    }

    let skip = 0, take = 0;
    for (let i = 1; i < arr.length; i++) {
        let temp = skip;
        skip = Math.max(skip, take)
        take = temp + arr[i];
    }
    return Math.max(skip, take);


};