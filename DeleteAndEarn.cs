// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 public int DeleteAndEarn(int[] nums) {
        
    if(nums == null || nums.Length == 0)
        return 0;

    int max = Int32.MinValue;

    //first we will get maximum element in array nums input
    foreach(int num in nums)
    {
        max = Math.Max(num, max);
    }

    //then we will build dp array of length max we calculated above
    int[] dp = new int[dp+1];
    foreach(int num in nums)
    {
        dp[num] = num + dp[num];
    }

    //we take skip 0 and take as dp first element
    int skip = 0;
    int take = dp[0];
    for(int i = 1; i < dp.length; i++)
    {
        //save skip in temp because we will update skip to new skip and we need old skip to calculate new take
        int temp = skip;

        //skip is maximum between previous skip and take
        skip = Math.Max(skip, take);
        //take is previous skip + current element
        take = skip + dp[i];
    }

    return Math.Max(skip, take);
 }