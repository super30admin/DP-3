class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int[] values=new int[max+1];
        int skip=0;
        int taken=0;
        for(int i=0;i<nums.length;i++)
        {
            values[nums[i]]+=nums[i];
        }
        for(int i=1;i<values.length;i++)
        {
            int currSkip=Math.max(skip,taken);
            int currTaken=values[i]+skip;
            skip=currSkip;
            taken=currTaken;
        }
        return Math.max(skip,taken);
        
    }
}