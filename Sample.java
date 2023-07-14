// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i: nums)
            max=Math.max(max,i);

        int[] arr=new int[max+1];

        for(int i: nums)
            arr[i]+=i;
        //int prev=arr[0];
        //int cur=Math.max(arr[0],arr[1]);
        arr[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            // int temp=cur;
            // cur=Math.max(cur,arr[i]+prev);
            // prev=temp;
            arr[i]=Math.max(arr[i-1],arr[i-2]+arr[i]);
        }
        return arr[max];
    }

    // public int deleteAndEarn(int[] nums) {
    //     if(nums==null || nums.length==0) return 0;


    //     int max=0;
    //     //for loop to fid max of given array so that we create an array
    //     for(int n: nums){
    //         max=Math.max(max, n);
    //     }

    //     int[] dp = new int[max+1];
    //     // keep number*frequency(basically total) of the index in the index
    //     for(int n: nums){
    //         dp[n]+=n;
    //     }

    //     int prev=dp[0];
    //     int cur=Math.max(dp[0],dp[1]);

    //     for(int i=2;i<dp.length;i++){
    //         int temp=cur;
    //         cur= Math.max(cur, dp[i]+prev);
    //         prev=temp;
    //     }
    //     return cur;
    // }

    //can also be done with hashmap, find min and max in 1 for loop and then do a for loop from min to max and find keys in hashmap.
    // public int deleteAndEarn(int[] nums) {
    //     if(nums==null || nums.length==0) return 0;


    //     int max=0;
    //     int min= Integer.MAX_VALUE;
    //     //for loop to fid max of given array so that we create an array
    //     for(int n: nums){
    //         max=Math.max(max, n);
    //         min=Math.min(min,n);
    //     }

    //     Map<Integer, Integer> dp=new HashMap<>();
    //     // keep number*frequency(basically total) of the index in the index
    //     for(int n: nums){
    //         dp.put(n,dp.getOrDefault(n,0)+n);
    //     }

    //     int prev=dp.get(min);
    //     int cur=prev;
    //     if(dp.containsKey(min+1)){
    //         cur=Math.max(prev,dp.get(min+1));
    //     }

    //     for(int i=min+2;i<=max;i++){
    //         int temp=cur;
    //         if(!dp.containsKey(i)){
    //             cur=Math.max(cur, 0+prev);
    //         }
    //         else
    //             cur= Math.max(cur, dp.get(i)+prev);
    //         prev=temp;
    //     }
    //     return cur;
    // }