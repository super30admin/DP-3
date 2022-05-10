// Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int deleteAndEarn(int[] nums) {
         if(nums.length==1)
            return nums[0];
        if(nums[0]>nums[1])
            nums[1]=nums[0];
        if(nums.length==2)
            return nums[1];
        Arrays.sort(nums);
        int[] temp=new int[nums[nums.length-1]+1];
        Arrays.fill(temp,0);
        for(int num:nums){
            temp[num]+=num;
        }
        for(int i=2;i<temp.length;i++)
        {
            temp[i]=Math.max(temp[i]+temp[i-2],temp[i-1]);
        }
        return temp[temp.length-1];
    }
}