class deleteandearn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        //initializing Dp array.
        int[] dp = new int[getMax(nums)+1];

        for(int x:nums){
            dp[x]+=x;
        }

        //same as house robber technique.
        int C=0;int DC=0;
        for(int x: dp){
            int temp=DC;
            DC=Math.max(C,DC);
            C=temp+x;
        }
        return Math.max(C,DC);
    }
    //This function is to get max.
    private int getMax(int[] nums){
        int max=Integer.MIN_VALUE;

        for(int x:nums){
            if(x>max){
                max=x;
            }
        }
        return max;
    }
}

//time complexiy will be=O(n)