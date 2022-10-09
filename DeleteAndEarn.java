class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } 

        //Get the max number from nums
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Integer.max(max, nums[i]);
        }

        //With the max, create array of that size
        int[] dp = new int[max+1];

        // store the earnings for each point into dp array
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i];
            dp[idx] = dp[idx] + nums[i];
        }

        //Logic to choose current point and delete nums-1 and nums+1 value
        //DP: NotToChoose = Skip and Choose = Take
        //Imagine table to capture Choose and NotToChoose 
        //NotToChoose (Skip) ==> Max(Previous NotToChoose and choose)
        //Choose (Take) ==> Prevous Not Choose + Current value

        int NotToChoose = 0;
        int Choose = dp[0];

        for(int i = 1; i < dp.length; i++){
            int PrevNotToChoose = NotToChoose;
            NotToChoose = Integer.max(NotToChoose, Choose);
            Choose = PrevNotToChoose + dp[i];       
        }

        return Integer.max(NotToChoose, Choose);
    }
}

//Time Complexity = O(max number from nums) => O(n)
//Space complexity = O(max size of dp array ==> max from nums) => O(n) 