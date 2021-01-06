// Time Complexity : 0(Math.max(nums, values))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max = 0;

        for(int num : nums){
            max = Math.max(num, max);
        }

        int[] values = new int[max + 1];

        for(int i=0;i<nums.length;i++){
            values[nums[i]] += nums[i];
        }

        //transformed into house rob problem
        int skip = 0, take = values[0];

        for(int i=1;i<values.length;i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + values[i];
        }

        return Math.max(skip, take);
    }
    //time complexity -> 0(Max(max, nums.length))
}