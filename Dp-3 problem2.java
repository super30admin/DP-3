// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : at c and dc.


// Your code here along with comments explaining your approach:- initially an array of same elements are added and stored in another array with indices matching their values. next changing two variables c and dc based on choose or not and finally getting max value from both.

import java.util.*;
class Solution {
    public int deleteAndEarn(int[] nums) {
        if((nums.length==0)|| nums==null){
            return 0;
        }
        int[] a1=new int[maxofarray(nums)+1];
        for(int y:nums){
            a1[y]=a1[y]+y;
        }
        int c=0;
        int dc=0;
        for(int y:a1){
            int temp=dc;
            dc=Math.max(c,dc);
            c=y+temp;
        }
        
            
        
   return Math.max(c,dc); }
    public int maxofarray(int[] nums1){
        int max=Integer.MIN_VALUE;
        for(int x=0;x<nums1.length;x++){
            if(nums1[x]>max){
                max=nums1[x];
            }
        }
        
        
    return max;}
}