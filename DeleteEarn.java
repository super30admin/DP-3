class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int max =0;
        for(int i: nums)
        {
            max = Math.max(i,max);
        }
        int[] a = new int[max +1];
        int skip = 0;
        int take = a[1];
        System.out.println(take);
        for(int j=0;j<nums.length;j++)
        {   int index = nums[j];
            a[index] +=nums[j];
        }
        for(int i=0;i<a.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + a[i];
        }
        return Math.max(skip,take);
    }
}

//Time complexity is O(N)
//Space complexity is O(1)