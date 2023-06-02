class DeleteAndEarnRecursion {
    public int deleteAndEarn(int[] nums)
    {
        if(nums == null || nums.length < 1)
        {
            return 0;
        }
        return getMaxPoints(nums, 0);
    }

    private int getMaxPoints(int[] nums, int idx)
    {
        if(idx == nums.length -1)
        {
            return nums[idx];
        }
        if(nums[idx]==0)
        {
            //move to the next element
            return getMaxPoints(nums, idx+1);
        }
        //don't choose
        int case0 = getMaxPoints(nums, idx+1);
        //choose
        int[] newNums = new int[nums.length];
        int currentValue = nums[idx];

        for(int i =0; i<nums.length ; i++)
        {
            if(nums[i] != currentValue+1 && nums[i] != currentValue-1)
            {
                newNums[i] = nums[i];
            }
        }
        //now make the current deleted element also 0
        newNums[idx] = 0;
        int case1 = currentValue + getMaxPoints(newNums, idx+1);

        return Math.max(case0, case1);
    }
}