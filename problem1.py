class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        maxvalue=max(nums)
        arr=[0]*(maxvalue+1)
        for num in nums:
            arr[num]+=num
        consider=arr[0]
        skip=0
        
        for i in range(1,len(arr)):
            prev=consider
            consider=skip+arr[i]
            skip=max(prev,skip)
            
        return max(skip,consider)
        #Time O(n)
        #Space O(k)=k= max value in number array
        #https://leetcode.com/problems/delete-and-earn/submissions/
        #It ran successfully
