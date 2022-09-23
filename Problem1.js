//Time: O(n) + O(max value in arr)
//Space: O(max value in arr);

var deleteAndEarn = function(nums) {

    if(nums.length == 0) return 0;
    let max = Number.MIN_VALUE
       for(let i=0;i<nums.length;i++){
           max = Math.max(max,nums[i])
       }
       let dp = Array(max+1).fill(0);
       for(let i=0;i<nums.length;i++){
           let idx = nums[i]
           dp[idx] = dp[idx] + nums[i];
       }
       let skip=0, take=dp[0];
        for(let i=1;i<=max;i++){
            let temp = skip;
            skip = Math.max(skip , take);
            take = temp + dp[i]
        }
       return Math.max(skip,take);
   };
   
   