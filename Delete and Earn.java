
// time complexity is O(n) (since we have to iterate through nums array )
// and space complexity is  O(1) (fixed)
// this code works well
// here we are maintaning a values array which maintains the amount if we take that number 
// and then we are maintaining 2 variables skip and take which are getting updated by curr_skip and curr_take and in the last we are taking the max of the skip and take values
class Solution {
    public int deleteAndEarn(int[] nums) {
       int [] values =new int[10001];
        int skip=0,take=0;
        for(int num:nums) values[num]+=num;
        for(int i=0;i<10001;i++)
        {
            int curr_skip=Math.max(skip,take);
            int curr_take=skip+values[i];
            skip=curr_skip;
            take=curr_take;
        }
       return Math.max(skip,take); 
    }
}