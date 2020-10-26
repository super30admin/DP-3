// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var deleteAndEarn = function(nums) {
    if(nums.length === 0) return 0;
    if(nums.length === 1) return nums[0];

    const numsLookUp = new Array(nums.length + 1).fill(0);

    for(let i = 0; i < nums.length; i++){
        if(numsLookUp[nums[i]]) {
            numsLookUp[nums[i]] += nums[i];
        }
        else {
            numsLookUp[nums[i]] = nums[i];
        }
    }
    console.log(numsLookUp)

    // same logiv as house robber. keeping track of max two values
    let secPrev = numsLookUp[0], prev = numsLookUp[1];

    for(let i = 2; i < numsLookUp.length; i++){
        const temp = prev;
        prev = Math.max(numsLookUp[i] + secPrev, prev);
        secPrev = temp;
    }
    return prev
};

console.log(deleteAndEarn([3,4,2]))