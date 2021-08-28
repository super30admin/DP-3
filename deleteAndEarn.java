// Time Complexity :O(n)+O(max(arr))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class deleteAndEarn{
    public int deleteAndEarn(int[] nums) {
        if(nums==null) return 0;
        int max=Integer.MIN_VALUE;
        for(int num : nums){
            max=Math.max(max,num);
        }
        int arr[]=new int[max+1];
        for(int num : nums){
            arr[num]=arr[num]+num;
        }
        int skip=0; int take=0;
        for(int i=0;i<arr.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+arr[i];
        }
        return Math.max(skip,take);
    }
}