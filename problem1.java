// Time Complexity :  O(2^n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode :  Brute Force Time Limit exceed. Ran on vs code
// Any problem you faced while coding this :  No


// Brute Force- Simple recursion using hashmap to store frequencies of each nach number in the array
// each time we chose a number x from the array, we will nullify x-1 and x+1 numbers in the hashmap
// and increase score by x*(frequency of x). Compute the value. Next restore to the previous state. Now dont choose.
// Return max of both.


import java.util.*;

class Solution1 {

    HashMap<Integer,Integer> map= new HashMap<>();

    int findSolution(int[] nums, int index){
        int Score=0;
        if(index==nums.length){
            return 0;
        }
        int x= nums[index];
        // Skip the number for NotChose
        int notChose= findSolution(nums,index+1);
        int freq= map.get(x);
        // Add all x to score at a time
        Score+= freq*x;
        // nullfy x,x-1,x+1
        map.put(x,0);
        int before= map.containsKey(x-1)? map.get(x-1) : 0;
        map.put(x-1,0);
        int after= map.containsKey(x+1)? map.get(x+1) : 0;
        map.put(x+1,0);
        // Call chose
        int choose= findSolution(nums,index+1);
        //put back x,x-1,x+1
        map.put(x-1,before);
        map.put(x,freq);
        map.put(x+1,after);
        return Math.max(notChose,Score+choose);

    }

    public int deleteAndEarn(int[] nums) {
        
        // populate the frequency hashmap
        for(int num: nums){
            // if map doean't contains the key take default 0 else take it's value
            int k = map.getOrDefault(num, 0);
            k++;
            map.put(num,k);
        }

        return findSolution(nums,0);
    }
}

public class problem1 {
    public static void main(String[] args) {
        int[] nums ={1,8,5,9,6,9,4,1,7,3,3,6,3,4,7,4,1,9,5,1,5,7,5};
        Solution1 s1= new Solution1();
        System.out.println(s1.deleteAndEarn(nums));
    }
}
