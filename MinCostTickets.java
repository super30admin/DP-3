/**
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 * 1st: Recursive Approach then Iterative DP
 *
 * 
 */
// Time Complexity : O(3^W)    --3- difft types of passes/tickets, W-days -365
// Space Complexity : O(1)     --since 365 is a constant
// Did this code successfully run on Leetcode : no - Time Limit Exceeded
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach

/**
 * Each day travelled, calc. min of ( 1 day pass cost + next day travel cost calculated ,
 *                                      7 day pass cost + 7 days later calc. travel cost(sicne till then 7 day pass covers),
 *                                      30 day pass cost + 30 days latr calc. travel cost)
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0 || costs == null || costs.length == 0)
            return 0;
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int day:days)
            hset.add(day);
        int minamt = helper(costs,hset,days[0],Integer.MAX_VALUE);
        return minamt==Integer.MAX_VALUE ? 0 : minamt;
    }
    private int helper(int[] costs,HashSet<Integer> hset,int day,int amt){
        //base
        if(day>365){
            return 0;
        }
        //System.out.println(day);
        if(hset.contains(day)){
            amt = Math.min(helper(costs,hset,day+1,amt)+costs[0],
                    Math.min(helper(costs,hset,day+7,amt)+costs[1],
                            helper(costs,hset,day+30,amt)+costs[2]));
        }else
            amt = helper(costs,hset,day+1,amt);

        return amt;
    }
}

/**
 * Iterative - DP approach
 * An array indicating the all the days(irresp. of his travelled days) from 0,1,2,3....last day he travelled(days array - last val)
 *  Each day - indicates the minimum amt required to travel until that day.
 *  Ex: dp[0] = 0 --default.
 *  if user wants to travel on 5,6 then dp[1] = 0 dp[2]=dp[3]=dp[4] = 0 and dp[5] --chk the min val obtained from calc the costs.
 *
 *  Cost calcuation - Math.min(dp[i-1]+costs[0],
 *                         Math.min(dp[Math.max(i-7,0)]+costs[1],dp[Math.max(i-30,0)]+costs[2]));
 */

// Time Complexity : O(N) unique days user has travelled --max can be 365
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];    // the last day on which he has travelled
        int local = 0; //days array count
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            if(i == days[local]){
                local++;
                dp[i] = Math.min(dp[i-1]+costs[0],
                        Math.min(dp[Math.max(i-7,0)]+costs[1],dp[Math.max(i-30,0)]+costs[2]));
            }
            else
                dp[i] = dp[i-1];
        }

        return dp[dp.length-1];

    }
}