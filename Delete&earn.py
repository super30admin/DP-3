#Time Complexity: O(n)+O(max(n))
#Space Complexity: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxsize=0
        for i in range(len(nums)):
            maxsize=max(nums[i],maxsize)
        arr=[0]*(maxsize+1)
        for i in range(len(nums)):
            arr[nums[i]]=arr[nums[i]]+nums[i]
        prev=arr[0]
        curr=max(arr[0],arr[1])
        for i in range(2,len(arr)):
            temp=curr
            curr=max(temp,prev+arr[i])
            prev=temp
        return curr