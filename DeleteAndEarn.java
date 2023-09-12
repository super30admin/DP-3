class DeleteAndEarn {
    //Need return the max earnings and can not choose previous and next element.
    //TC will be O(N) + O(max), as there are 2 arrays and both of them might have different sizes and are iterating over the both arrays.
    //SC will be O(max), as maintaing an array of max size

    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){       //base case to check is array is empty.
            return 0;   //no earnings
        }

        int n = nums.length;        //Variable to get the length
        int max= Integer.MIN_VALUE;     //Variable to store the max element in the given array, initially initializing it to -ve infinity.

        for(int i =0; i<n; i++){        //To iterate over the array to get the max value
            max= Math.max(max,nums[i]);     //keep checking and updating the value of max.
        }

        int[] dp = new int[max+1];      //Array to store the preprocessed earnings for each value in th given nums array.

        for(int i=0; i<n; i++){         //Iterate over the nums array to update dp array
            int index = nums[i]; //It will store the number from nums array as index in dp array.
            dp[index]+= nums[i];  //to populate the earnings for the number in nums array in the dp array
        }

        int skip=0;     //To skip the adjacent value
        int take=0;     //to take the adjacent value

        for(int i =1; i<dp.length; i++){        //iterate over the dp array to get max earnings, starting from 0 as index represents the each value in nums.
            int temp = skip;   //storing the value of skip before updating.
            skip= Math.max(skip, take);     //updating skip to the max value
            take = temp + dp[i];            //updating take with current earnings
        }


        return Math.max(take, skip);        //Returning the max of skip and take
    }


    public static void main(String[] args){
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {3,4,2};
        System.out.println(obj.deleteAndEarn(nums));

    }
}