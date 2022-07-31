// time complexity 0(n);
// space constant
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0 || nums== null)
            return 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int arr[]=new int[max+1];
        for(int num:nums)
        {
            arr[num]=arr[num]+num;
        }
        int skip=0; int take=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[i];
        }
        return Math.max(skip,take);
    }
}