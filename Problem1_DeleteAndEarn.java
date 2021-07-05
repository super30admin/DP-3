// Time Complexity : O(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
       
        if(nums== null||nums.length==0)
            return 0;

        int max=Integer.MIN_VALUE;
        
        //update max
        for(int num:nums)
        {
            if(num>max)
                max=num;
        }
        
        int[] array=new int[max+1];
        
        //storing occurences of each element
        for(int num:nums)
        {
            array[num]+=num;
        }
        
        int skip=0;
        int choose=array[0];
        
        for(int i=0;i<array.length;i++)
        {
            int prevSkip=skip;
            skip=Math.max(prevSkip,choose);
            choose=prevSkip+array[i];
        }
        return Math.max(skip,choose);
    }
}
