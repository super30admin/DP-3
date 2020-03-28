// I could not get it to run for all test cases. Tried DP solution also but didn't get it to work.


class DeleteAndEarnRecursive {
    int result=Integer.MIN_VALUE;
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0)  return 0;
        
        dfs(nums, 0, -1, 0);
        return result;
    }
    
    public void dfs(int[] nums, int curr, int prev, int runningSum)
    {
        //base case: when we reach the end of nums array

            if(curr==nums.length)
            {
                result=Math.max(result,runningSum);
                return;
            }
            // chose
            if(curr>0&&Math.abs(nums[curr]-nums[prev])==1)
                dfs(nums,curr+1,prev,runningSum);
            else
                dfs(nums,curr+1,curr,runningSum+nums[curr]);
            // not choose
            dfs(nums,curr+1,prev+1,runningSum);

    }


    public static void main(String[] args)
    {
        DeleteAndEarnRecursive d = new DeleteAndEarnRecursive();
        int[] nums = {3, 4, 2};
       System.out.println( d.deleteAndEarn(nums));
    }
    
}