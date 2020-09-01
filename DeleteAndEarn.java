import java.util.*;

//Time Complexity : O(n+c) c is the size of the count
//Space Complexity : O(c) c is size of the count
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        int points[]=new int[10001];
        for(int num:nums)   points[num]+=num;
        int takei=0,skipi=0,take=0,skip=0;
        for(int i=0;i<points.length;i++){
            takei=skip+points[i];
            skipi=Math.max(take,skip);
            take=takei;
            skip=skipi;
        }
        return Math.max(skip,take);
    }
}
