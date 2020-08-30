//Time Complexity- O(n)
//Space Complexity=O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0||
          nums==null)
        {
            return 0;
        }
        int[] newArray=new int[getMaxAmountValue(nums)+1];
        for(int i=0;i<nums.length;i++)
        {
            newArray[nums[i]]+=nums[i];
        }
        int dc=0;
        int c=0;
        for(int i=0;i<newArray.length;i++)
        {
            int temp=dc;
            dc=Math.max(c,dc);
            c=temp+newArray[i];
                       
        }
        return Math.max(c,dc);
        
    }
    int getMaxAmountValue(int[] nums)
    {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];
                }
            }
            return max;
        }
}