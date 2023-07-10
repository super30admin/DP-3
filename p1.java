// Time Complexity : time complexity would be O(n) + O(max(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        //Using hashmap to store values and their frequency
        Map<Integer, Integer> map = new HashMap<>();
        //Variable for getting min and max value
        int min = 20001;
        int max = 0;
        // Iterating through the array to get the min and max value and storing values and frequency in hashmap
        for(int i=0; i< nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        
        
        // Getting value for previous and current pointer from the hashmap
        int prev = map.get(min)*min;
        int curr = Math.max(prev, map.getOrDefault(min+1,0)*(min+1));
        System.out.println(prev);
        System.out.println(curr);
        //Iterating through the hashmap to get the max number of points
        for(int i = min+2; i<=max; i++){
            int temp = curr;
            curr = Math.max(curr, (map.getOrDefault(i,0)*(i))+prev);
            prev = temp;
        }

        return curr;
    }
}