// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;

// Your code here along with comments explaining your approach
/*

The code first creates a HashMap to store the sum of occurrences of each unique number in the nums array. It also tracks the minimum and maximum values in the array.

It then initializes prev to the sum of occurrences of the smallest number and sets curr based on whether the next consecutive number exists in the map.

The loop iterates from min + 2 to max, deciding whether to include the current number by comparing the sum of its occurrences with the previously computed values.

If the current number exists in the map, the algorithm either adds it to prev or keeps curr as is. If it doesn’t exist, curr remains the same.

The approach follows a dynamic programming pattern similar to the "House Robber" problem, where adjacent elements cannot be selected together, ensuring the maximum sum is obtained.
*/
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+num);
            max=Math.max(max,num);
            min=Math.min(min,num);
        }

        int prev=map.get(min);
        int curr = 0;

        if(map.containsKey(min+1))
        {
            curr=Math.max(prev,map.get(min+1));
        }
        else
        {
            curr=Math.max(prev,0);
        }

        for(int i=min+2;i<=max;i++)
        {
            int temp=curr;
            if(map.containsKey(i))
            {
                curr=Math.max(curr,map.get(i)+prev);
            }
            else
            {
                curr=Math.max(curr,0 + prev);
            }
            prev=temp;
        }
        return curr;
    }
}