// Time Complexity : O(Y) where Y is 365
// Space Complexity : O(Y) where Y is 365 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*

*/

class Solution {
    public int mincostTickets(int[] days, int[] pass) {
        if(days == null || days.length == 0) return 0;
        
        //why use hashset? to check quickly if we are traveling that day or not
        Set<Integer> daySet = new HashSet<>();
        for(int i: days) daySet.add(i);
        
        // Because we have max 365 days, choosing that+1 as length of array
        int[] cost = new int[366];
        cost[0] = 0;
        
        for(int i = 1; i < 366; i++) {
            if(!daySet.contains(i)) 
                cost[i] = cost[i-1];
            else 
                
        }
        
        return cost[365];
    }
}