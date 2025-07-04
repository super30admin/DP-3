class Solution {
    public int deleteAndEarn(int[] nums) {
       if( nums==null || nums.length==0) return 0;
       int maxi=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        maxi=maxi>nums[i]?maxi:nums[i];
       }
       int[] arr=new int[maxi+1];
       for(int i=0;i<nums.length;i++){
       int index=nums[i];
       arr[index]=arr[index]+nums[i];
       }
       int take=0;
       int skip=0;
       for(int i=1;i<maxi+1;i++){
           int temp=skip;
           skip=Math.max(skip,take);
           take=temp+arr[i];
       }
       return Math.max(skip,take);

    }
}