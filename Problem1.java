// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting previous optimal calculation


// Your code here along with comments explaining your approach
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

// Approach 1: Brute force
// Time Complexity : O(2^(n) + nlogn)
//      n: array length
//      nlogn for sorting
// Space Complexity : O(n)
//      It is recursive space

class Problem1BruteForce {

    /** find maximum poinst earned */
    public int deleteAndEarn(int[] nums) {

        // base condition
        if(nums==null || nums.length==0)
            return 0;
        // sorting
        Arrays.sort(nums);
        return helper(nums, 0, 0);
    }
    
    /**
     * helper function
     * @param nums array
     * @param index index of array
     * @param earned earned
     * @return int
     */
    private int helper(int[] nums, int index, int earned){

        // array index out of bounds
        if(index>=nums.length)
            return earned;
        
        // not chose the number    
        int notChose = helper(nums, index+1, earned);

        // else chosing the current number
        int tempIndex = index+1;
        // add to earned
        earned += nums[index];
        
        // finding the next choice
        while(tempIndex<nums.length){
            // if it equals to current number
            if(nums[index] == nums[tempIndex])
                earned += nums[index];
            // not equal to neighbor    
            else if (nums[tempIndex] != nums[index]+1){
                tempIndex--;
                break;
            }
            
            tempIndex++;
        }
        
        // get amount earned if chosen
        int chose = helper(nums, tempIndex+1, earned);
        
        // return max of either choice
        return Math.max(notChose, chose);
        
    }
}

// Approach 2: Dynamic Programming
// Time Complexity : O(n + m)
//      n: array length
//      m: max of array
//  for finding max and intnialize dp matrix O(n+n) = O(2n) = O(n)
// Space Complexity : O(m)
//      m: max of array
class Problem1Dp1 {
    public int deleteAndEarn(int[] nums){

        // base condition
        if(nums==null || nums.length==0)
            return 0;

        // find max of array
        int max = Arrays.stream(nums).max().getAsInt();

        // intialize dp 
        int [][] dp = new int[max+1][2];

        // iterating (creating a cost matrix)
        for(int num:nums){
            dp[num][1] += num;
        }
        
        // iterating dp matrix
        for(int i=1;i<dp.length; i++ )
        {
            // not chosing an element.. max of either choice
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            // chosing element adding amount for previous element not chosen
            dp[i][1] += dp[i-1][0];
        }
        
        // return max of either choice
        return Math.max(dp[max][0], dp[max][1]);
    }
}

// Approach 3: Dynamic Programming
// Time Complexity : O(nlogn + n)
//      n: array length
//  for creating tree map (sorted): nlogn
// Space Complexity : O(n)
//      n: max of array
//      O(n + n*2) = O(3n) = O(n)
//      treeMap: n
//      dp matrix: n*2

class ProblemDP2 {
    public int deleteAndEarn(int[] nums){
        if(nums==null || nums.length==0)
            return 0;
        // sorted map and value
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // intialize map
        for(int num:nums){
            if(!map.containsKey(num))
                map.put(num, 0);
            int value = map.get(num);
            map.put(num, num+value);
        }
        
        // initialize dp matrix
        int [][] dp = new int[map.size()+1][2];
        dp[0][0] = dp[0][1] = 0; // for zero amount

        // starting from 1st element
        int i = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // not chosing
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            // chosing first find if neighbor is present than previous was neighbor
            if(map.containsKey(entry.getKey()-1))
                dp[i][1] = entry.getValue() + dp[i-1][0];
            else
            //no neighbor
                dp[i][1] = entry.getValue() + dp[i][0];
            i++;
        }
        // max of either choice
        return Math.max(dp[map.size()][0], dp[map.size()][1]);
    }
}