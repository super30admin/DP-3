
//Time Complexity : O(m) , m = max(days)
//Space Complexity : O(m) , m = max(days)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : 

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * In a country popular for train travel, you have planned some train traveling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
 */

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<>();
        
        //create set for available days
        for(int day:days) {
          daysSet.add(day);  
        }
        
        int max = days[days.length-1];
        
        //make dp arrays with length of max days + 1
        int[] dp = new int[max+1];
        
        for(int i=1 ;i< max+1;i++) {
            //if day not present in given days, cost to reach that day
            //is same as of previous day
            if(!daysSet.contains(i)){
                dp[i] = dp[i-1];
            } else
            {
                //if day present in the days, it can be reached using 1, 7, 30 day pass
                // consider 7 day pass, so we reach this from (currentDay - 7)th day
                //if (current-7) is valid day then cost of that day + cost of 7 day pass
                // else use cost of 0th day, do this for all options (1,7,30) and take min
                dp[i] = Math.min(
                    dp[i-1] + costs[0], 
                    Math.min(    
                    dp[Math.max(i-7, 0)] + costs[1],
                    dp[Math.max(i-30, 0)] + costs[2]  
                    )
                );
            
            }
        }
        
        return dp[max];
    }
    
    
}