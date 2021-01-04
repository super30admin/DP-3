// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {

        int[] dp = new int[10001];
        int prev = -1;
        int using = 0;
        int avoid = 0;

        // Add the count of each number
        for(int num:nums){
            dp[num]++;
        }

        for(int i=1;i<dp.length;i++){

            if(dp[i] == 0) {continue;}

            // Maximum of either using or not using the value
            int m = Math.max(avoid,using);

            // If previous number is not present, get the sum for using and not using
            if(prev != i-1){
                using = i*dp[i] + m;
                avoid = m;
            }
            // If previous number is present, get the sum for using and not using
            else{
                using = i*dp[i] + avoid;
                avoid = m;
            }
            prev = i;
        }

        return Math.max(using,avoid);

    }
}


// Time Complexity : The time complexity is O(3^n) where n is the length of the array
// Space Complexity : The space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }

        return recursive(map);

    }

    public int recursive(Map<Integer,Integer> map){

        int max = 0;
        int left = 0;
        int right = 0;

        for(int each:map.keySet()){

            if(map.get(each) == 0){
                continue;
            }

            int val = map.get(each);
            map.put(each,0);

            if(map.containsKey(each-1) && map.get(each-1) != 0){
                int leftVal = map.get(each-1);
                map.put(each-1,0);
                left = recursive(map);
                map.put(each-1,leftVal);
            }

            if(map.containsKey(each+1) && map.get(each+1) != 0){
                int rightVal = map.get(each+1);
                map.put(each+1,0);
                right = recursive(map);
                map.put(each+1,rightVal);
            }

            max = Math.max(left,right) + (each*val);
            map.put(each,val);

        }

        return max;
    }
}