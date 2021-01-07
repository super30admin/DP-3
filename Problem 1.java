//Time Complexity: O(max(max(res), N)) where N is the length of nums array and res is the auxiliary array 
//Space Complexity: O(max(res))

//Approach: Dynamic Programming


class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(max, nums[i]);
        }
        
        int [] res = new int[max+1];
        
        for(int num: nums)
            res[num] += num;
        
        int skip = 0; int take = res[0];
        for(int i = 1; i < res.length; i++)
        {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + res[i];
        }
        return Math.max(skip,take);
    }
}