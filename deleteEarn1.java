public class deleteEarn1 {
        public int deleteAndEarn(int[] nums) {
            if(nums == null || nums.length==0 ){
                return 0;
            }
            int n=nums.length;
            int max=Integer.MIN_VALUE;
    
            for(int i=0;i<n;i++){
                max=Math.max(max,nums[i]);
            }
            int[] dp=new int[max+1];
    
            for(int i=0;i<n;i++){
                int index=nums[i];
                dp[index]+=nums[i];
            }
            int skip=0;
            int take =dp[0];
    
            for(int i=1;i<dp.length;i++){
                int temp=skip;
                skip=Math.max(skip,take);
                take=temp+dp[i];
            }
            return Math.max(skip,take);
        }
    
    }
