// Time Complexity : O(n)+ O(m+1) where m is max size of the array Iterate through the array
// Space Complexity : O(1) As I am using HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// After class on Friday from cohort I was able to solve this problem on Delete and Earn


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        // Assign Min and Max values to iterate loop over Min to Max

        int max = 0;
        int min = Integer.MAX_VALUE;

        // Create a hashmap to store the value and its sum
        HashMap<Integer,Integer> map = new HashMap<>();

        // Assign Min Max and Sum of values to hashmap
        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+num);
            min = Math.min( num, min);
            //find max
            max = Math.max(num,max);
        }

        //Similar to House Robber problem LC: 198
        int prev = map.get(min);
        int curr = Math.max(map.get(min), map.getOrDefault(min + 1, 0));
        for( int i=min+2;i< max+1;i++){
            int temp = curr;
            if(map.containsKey(i)){
                curr= Math.max(curr,map.get(i)+prev);    
            }
            else{
                curr= Math.max(curr,0+prev);  
            }
            prev=temp;
        }
        return curr;

    }
}