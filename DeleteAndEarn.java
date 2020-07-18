//space - O(n) - for support and result arrays
//time - O(max(n, max(elements in list)))

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        //if a particular element is selected, then all occurences of that element are sselected
        int max = Integer.MIN_VALUE;
        for(int num : nums) 
        {
            max = Math.max(max, num);
        }
        
        //[2,2,2,3,3,4] becomes - [0,0,6,6,4]
        int[] support = new int[max + 1];
        
        for(int i = 0; i < nums.length; i++)
        {
            support[nums[i]] += nums[i];
        }
        
        int[] result = new int[support.length];
        result[0] = support[0];
        result[1] = Math.max(support[0], support[1]);
        
        for(int i = 2; i < result.length; i++)
        {
            result[i] = Math.max(support[i] + result[i - 2], result[i - 1]); //same as house robber
        }
        
        return result[support.length - 1];
    }
}
