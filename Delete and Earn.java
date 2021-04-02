/*
Time Complexity : O(MAX(m,n)). n is the maximum value in nums array and length of nums array
Space COmpelxity : O(n). n is the maximum value in nums array
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        //find the maximum element in the array to create an array of size max to keep record of the sum for each occcurence of each element
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        //declare an array of size max
        int[] arr = new int[max+1];//+1 is used as the max value is also included
        
        //inser the elements into this array based on index
        for(int num : nums){
            arr[num] = arr[num]+num;
        }
        //similar to house robber problem. Have choose and not choose and find the max value
        int choose=0, notchoose = 0,temp=0;
        //iterate through the array
        for(int i=0;i<arr.length;i++){
            choose = temp + arr[i];
            temp = notchoose;
            notchoose = Math.max(choose,notchoose);//among the choose and not choose values pick the max for the next not choose inorder not to miss the largerst value in between
        }
        return Math.max(choose,notchoose);
    }
}