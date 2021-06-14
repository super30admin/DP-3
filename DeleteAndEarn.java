class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max =0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int[]arr=new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }
        int skip=0; int take=arr[0];
        for(int k=0;k<arr.length;k++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[k];
        }
        return Math.max(skip,take);
        
    }
}