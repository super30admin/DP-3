// Time Complexity : O(n+max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : yes


class deleteAndEarn {
        public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int[] dp=new int[max+1];

        for(int i=0;i<nums.length;i++){
            int index=nums[i];
            dp[index]=dp[index]+index;
        }
        int skip=0;
        int take=dp[0];

        for(int i=1;i<max+1;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+dp[i];
        }
        return Math.max(skip,take);
        
    }

    public static void main(String[] args) {
    deleteAndEarn rs = new deleteAndEarn();
    int[] arr = {3,4,2};
    int[] arr2 = {2,2,3,3,3,4};
    System.out.println(rs.deleteAndEarn(arr));  // ans = 6
    System.out.println(rs.deleteAndEarn(arr2));  // ans = 9
}

}