class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max=0;
        for(int num:nums)
        {
            max=Math.max(num,max);//we take the max number from the nums array
        }
        int[] arr=new int[max+1]; //create an array of size max 
        for(int j=0;j<nums.length;j++)
        {
            int index=nums[j];
            arr[index]+=nums[j];//we store the sum of 2s in the index 2 of the new array
        }
        int skip=0; int take=arr[0];
        for(int k=0;k<arr.length;k++)
        {
            int temp=skip;//we matain a variable to store the previous skip value
            skip=Math.max(skip,take);//when we dont choose to delete we store the max of the previos skip and take
            take=temp+arr[k];//when we choose to delete we add the previous skip value with the corresponding value in the array
        }
        return Math.max(skip ,take);//return the max to get the max possible earnings
    }
}
