
// Time Complexity :O(N)
// Space Complexity :O(m) where m is the max element in the nums array.
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

public class DeleteAndEarn{
        public int delete_and_Earn(int[] nums) {
            int max=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            int arr[]=new int[max+1];
            for(int x: nums){
                arr[x]+=x;
            }
            int take=0;int skip=0;
            for(int i=0;i<arr.length;i++){
               int temp=skip;
                skip=Math.max(take,skip);
                take=temp+arr[i];
                
            }
            return Math.max(take,skip);
        }
    public static void main(String args[]){
        DeleteAndEarn obj=new DeleteAndEarn();
        int nums[]={2,3,3,3,2,4,5,5};
        System.out.println(obj.delete_and_Earn(nums));
    }
}