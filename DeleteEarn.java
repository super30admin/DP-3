// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1 - Process nums array into a workable format
 * 2 - After reducing the array to a workable format, it is simply a house robber pattern problem
 */

public class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        
        for(int num:nums)
        {
            max = Math.max(max,num);
        }
        
        int[] arr = new int[max + 1];
        for(int num:nums)
        {
            arr[num] += num;
        }
        
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++)
        {
            int temp = curr;
            curr = Math.max(prev + arr[i],temp);
            prev = temp;
        }
        return curr;
    }
}
