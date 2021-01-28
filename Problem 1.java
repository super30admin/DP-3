//I counted the occurence of each number and stored it at the index of new array
//Next i maintained a max and prevmax, since array index is sorted we just need to add current pointer with prev max and compare with current max.
//Time complexity- O(n+n)~ O(n) , Space complexity-O(n)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int arr[]= new int[10000];
        for(int i=0;i<nums.length;i++)
            arr[nums[i]]+=nums[i];
      
        int prevmax=arr[0];
        int ans=arr[1];
        int temp=0;
        for(int i=2;i<arr.length;i++)
        {
            if(ans<prevmax+arr[i]){
             temp=ans;
            ans=arr[i]+prevmax;
           prevmax=temp;
            }
            else
            {
                prevmax=ans;
                
            }
         }
        return ans;
    }
}