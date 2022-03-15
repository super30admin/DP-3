class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums== null) return 0;
    
        int max=0;
         for(int i=0; i< nums.length; i++){
           max= Math.max(max, nums[i]);
        }
        int [] arr= new int[max+1];
        for(int i=0; i< nums.length; i++){
            arr[nums[i]]+= nums[i];
        }
        //house robber
        int skip=0,  take=0;
        for(int i=1; i<arr.length; i++){
            int temp= skip;
            skip= Math.max(skip, take);
            take= temp+arr[i];
        }
        return Math.max(skip, take);
    }
}

//time complexity- O(n) or max(n,k)
//space complexity- O(k) where k is max int in n