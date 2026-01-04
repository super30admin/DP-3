// Time Complexity : O(max(n)) max arr value
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We find the max element in given nums, and create array from 0 to that num
// add every element to the created array, so we have kind of key-value in that array
// we craeted a dp, that stores max pssoible by now, either we can take current value, and prev to prev or the prev one
//return the dp last element
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        //find max in array
        for(int num : nums)
        {
            max = Math.max(num,max);
        }
        //create an array till that
        int[] arr = new int[max+1];
        for(int num : nums)
        {
            arr[num] += num;
        }
        //create the key-value weighted sum
        int dp[] = new int[max+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        //itertare dp either to take max of current one + i-2 or prev one
        for(int i=2; i<=max; i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        //return last element
        return dp[max];
    }
}