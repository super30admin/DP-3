// Time Complexity : O(n)
// Space Complexity : O(m) where m is the max size of the array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : nopes


class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums==null||nums.length==0)
            return 0;

        int max=Integer.MIN_VALUE;

        //take maxium size array
        //Lets say maximum is 4 then ar size is 4

        //calculate maximum
        for(int num:nums)
        {
            max=Math.max(num,max);
        }
        int[] arr=new int[max+1];

        //add and place at the right index
        // [1,2,3,3,3,4]
        // [0,1,2,9,4]
        for(int num:nums)
        {
            arr[num]=arr[num]+num;

        }

        int skip=0;
        int take=arr[0];

        //       0(skip)  1(take)
        //0->0      0       0
        //1->1      0       0+1
        //2->2      1       0+2
        //3->9      2       1+9
        //4->4      10      2+4
        //Math.max value between take and skip is the ans

        for(int i=0;i<arr.length;i++)
        {
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[i];
        }

        return Math.max(skip,take);
    }
}