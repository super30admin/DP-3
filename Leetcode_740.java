//way1:
//Exhaustive- store the counts of each num in a array
//Then expore all the possible ways
//TC: 2^n where n is max number in nums
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;

        for(int n:nums){
            max=Math.max(max,n);
        }

        int[] arr=new int[max];

        for(int n:nums){
            arr[n-1]+=1;
        }

        System.out.println(max);
        System.out.println(arr.length);

        return helper(arr,0);
        
    }

    private int helper(int[] arr,int i){
        //base case
        if(i>=arr.length) return 0;


        //logic
        //no choose
        
        int case1=helper(arr,i+1);

        //choose
        int case2=(arr[i]*(i+1))+helper(arr,i+2);

        return Math.max(case1,case2);
    }
}

//Way2:
//Exhaustive- store the counts of each num in a array
//Then expore all the possible ways -- causing time limit exceeded
//Memoization: store prev values and use them further
//TC: O(n)--> n is the max number in nums; SC: O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;

        for(int n:nums){
            max=Math.max(max,n);
        }

        int[] arr=new int[max];

        for(int n:nums){
            arr[n-1]+=1;
        }
        
        int[] memo=new int[max];

        return helper(arr,0,memo);
        
    }

    private int helper(int[] arr,int i, int[] memo){
        //base case
        if(i>=arr.length) return 0;

        if(memo[i]!=0) return memo[i];


        //logic
        //no choose
        
        int case1=helper(arr,i+1,memo);

        //choose
        int case2=(arr[i]*(i+1))+helper(arr,i+2,memo);

        memo[i]=Math.max(case1,case2);

        return Math.max(case1,case2);
    }
}


//way3
//Tabulation
//TC:O(n); SC: O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;

        for(int n:nums){
            max=Math.max(max,n);
        }

        int[] arr=new int[max];

        for(int n:nums){
            arr[n-1]+=1;
        }

        int[] dp=new int[max];

        dp[0]=arr[0];

        if(arr.length==1) return dp[0];
        
        dp[1]=Math.max(arr[0],2*arr[1]);

        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1],(i+1)*(arr[i])+dp[i-2]);
        }
        
        return dp[arr.length-1];
    }
}
