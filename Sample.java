// Time Complexity :O(n+k)
// Space Complexity :O(n+k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    private HashMap <Integer,Integer> points = new HashMap<>();
    private HashMap <Integer,Integer> temp = new HashMap<>();
    private int maxPoints(int num){
        if(num == 0) return 0;
        if(num == 1) return points.getOrDefault(1,0);
        if(temp.containsKey(num)) return temp.get(num);
        int sum = points.getOrDefault(num,0);
        temp.put(num,Math.max(maxPoints(num-1),maxPoints(num-2)+sum));
        return temp.get(num);
    }
    public int deleteAndEarn(int[] nums) {
            int maxNumber = 0;
        for(int num: nums){
            points.put(num, points.getOrDefault(num,0)+num);
            maxNumber = Math.max(maxNumber, num);
        }
        return maxPoints(maxNumber);
    }
}