//Time : O(n)+ O(m) where m = length of array upto Max element value in nums array
//Space: O(m) where m = length of array upto Max element value in nums array
class Solution {
    public int deleteAndEarn(int[] nums) {
        //base case
        if(nums==null || nums.length==0) return 0;
        int maxLength=Integer.MIN_VALUE;
        //find max array length of size maximum element in nums array
        for(int x:nums)
        {
            if(maxLength<x)
                maxLength=x;
        }     
        //create dp array of max length+1
        int[] arr=new int[maxLength+1];
        //fill values at the positions that contains sum of all the values for that element present in nums array
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]=arr[nums[i]]+nums[i];
            
        }
        
        int skip=0, earn=0;
        //hack: looping through whole array , no need to do arr[i] every time, we are looping sequentially and checking skip and earn values because thats what matters to us programatically, dont try to add into arr like other dp problems 
        for(int i=0;i<arr.length;i++)
        {
            int currentSkip=Math.max(skip,earn);
            int currentEarn=skip+arr[i];
            skip=currentSkip;
            earn=currentEarn;
        }
        
        return Math.max(skip,earn);
    }
}
