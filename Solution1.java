// Leetcode Problem : https://leetcode.com/problems/delete-and-earn/description/
// Time Complexity : O(n) where n is the maximum integer value present in given array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I create an array of size maximum number in given array + 1 and store the frequency of all numbers appearing in the array.
 * I set previous as 0 at first and current as the first element of the frequency array. I traverse from 1 to length of 
 * frequency array and set count[i] as Math.max(prev+count[i],curr). I then update previous to current and current to count[i].
 * At the end, I return count[count.length-1].
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(nums[i],max);
        }
        int count[] = new int[max+1];
        
        for(int i=0;i<nums.length;i++)
        {
            count[nums[i]]+=nums[i];
        }
        int prev = 0, curr = count[0];
        for(int i=1;i<count.length;i++)
        {
            count[i]=Math.max(prev+count[i],curr);
            prev=curr;
            curr=count[i];
        }
        return count[count.length-1];
    }
}