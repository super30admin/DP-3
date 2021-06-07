// Time Complexity : O(maximum of n and maximum amongst nums[0...n]))
// Space Complexity :O(maximum amongst nums[0...n])
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class DeleteEarn{
    public int deleteAndEarn(int[] nums) {
        //Similar to house coloring problem
        //the recursive tree for this is very complex at what order elements are getting deleted is difficult to know
       if(nums==null||nums.length==0)
           return 0;
        int max=Integer.MIN_VALUE;
        //O(n)
        for(int num:nums)
        {
            max=Math.max(max,num);
        }
        //we will store earnings in a different array
        //calculate earnings associated with each number
        //column will be 0 and 1 : decision to delete or not delete
        //if you delete 2, you cannot delete 3 because it will be gone
        int[] dp=new int[max+1];
        //O(max(nums))
        for(int num:nums)
        {
            dp[num]+=num;
            
        }
        
        //It simplifies to a house robber problem
        //we are skipping since we are deleteing 
         //O(max(nums))
        int skip=0;
        int take=0;
        for(int i=1;i<dp.length;i++)
        {
            int prevSkip=skip, prevTake=take;
            
            skip=Math.max(skip,take);
            take=prevSkip+dp[i]; 
        }
        
        return Math.max(skip,take);
    
    }
    public static void main(String[] args)
    {
        DeleteEarn obj=new DeleteEarn();
        int[] nums={2,2,3,3,3,4};
        System.out.println(obj.deleteAndEarn(nums));
    }
}
