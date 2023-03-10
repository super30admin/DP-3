// Time Complexity : O(max n) + O(n)
// Space Complexity : O(max n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We keep a track of max and initialize an array with that value. 
 * Create an array and initiliaze with 0 and add all the same elements and store it in the respective positions. 
 * Check max between the previous number and the latest addition in comparison to the current number. 
 * Return current which stores the number of ways. 
 */

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max =0; 
        if(nums==null || nums.length==0)
        return 0; 
        for(int num: nums)
        max = Math.max(num,max);
        int ar[]=new int[max+1];
        for(int num:nums)
        ar[num] +=num;
        int prev=ar[0];
        int curr=ar[1];
        for(int i=2; i < ar.length;i++){
        int temp = curr; 
        curr = Math.max(curr,ar[i]+ prev);
        prev = temp;
    }
    return curr;
}
}