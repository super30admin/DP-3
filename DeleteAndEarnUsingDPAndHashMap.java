// Time Complexity: O(n) + O(max(n))
// Space Complexity: O(max(n))
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - This solution uses a HashMap to handle sparse input.
// - Build a frequency map where key = number, value = total points from that number (number * frequency).
// - Track the minimum and maximum numbers in the array to define DP range.
// - Initialize DP variables:
//    - `prev` handles the maximum points up to (i-2).
//    - `curr` handles the maximum points up to (i-1).
// - For each number from (min + 2) to max:
//    - If the number exists in the map, choose between taking it (map.get(i) + prev) or skipping it (curr).
//    - If number does not exist, it's treated like skipping with no gain.
// - Return `curr` as the result.

class Solution {
    public int deleteAndEarn(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        //Create the Hashmap
        HashMap<Integer,Integer> map = new HashMap<>();
        //Find the frequiencies
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+num);
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        //Populate the dp variables
        int prev = map.get(min);
        int curr = prev;
        if(map.containsKey(min+1)){
            curr = Math.max(prev,map.get(min+1));
        }
        for(int i=min+2; i<=max; i++){
            int temp = curr;
            if(map.containsKey(i)){
                curr = Math.max(curr,map.get(i)+prev);
            }else{
                curr = Math.max(curr,0+prev);
            }
            prev = temp;
        }

        return curr;
    }
}