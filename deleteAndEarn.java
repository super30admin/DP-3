/*
Run time complexity : O(Max(M,N)) - where M is the maximum element in the nums array, and N is the length of the nums array (as we need to calculate the max element that need to loop through the entire element)

Space complexity - we are using res array of maximum element in the nums array - O(M)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int[] res=new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            res[nums[i]]=res[nums[i]]+nums[i];
        }
        int skip=0;
        int take=res[0];
        for(int i=1;i<res.length;i++)
        {
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+res[i];
        }
        return Math.max(skip,take);
    }
}
