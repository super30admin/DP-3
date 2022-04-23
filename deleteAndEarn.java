//TC : O(Max(nums,maximumElement)) SC : (maximumElement)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }

        int[] arr = new int[max+1];

        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }

        int skip =0;
        int take = arr[0];

        for(int i=1;i<arr.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + arr[i];
        }

        return Math.max(skip,take);
    }
}