// Time Complexity : O(N + R) where R is the range possible 
// Space Complexity : O(R)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Take count of each numbers
//Store in array count
//Again run loop and we have option to avoid the number of select
//We will keep the count of select and avoiding on each iteration
//Finally we will return the max of avoid and selec.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int [] hasharray = new int[10001];
        for(int x: nums)
            hasharray[x]+=1;
        
        int select = 0, avoid = 0, prev = -1;
        for(int i = 0; i < 10001; i++){
            int points = Math.max(select, avoid);
            if(hasharray[i] > 0){
                if(i - 1 != prev){
                    select = i * hasharray[i] + points;
                    avoid = points;
                }
                else{
                    select = i * hasharray[i] + avoid;
                    avoid = points;
                }
                prev = i;
            }
        }
        return Math.max(select, avoid);
    }
}