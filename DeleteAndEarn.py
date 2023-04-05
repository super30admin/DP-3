#Time Complexity: Overall time complexity=O(n)
Space Complexity=O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return 0
        tempMax=0
        l=len(nums)
        #Getting the length of the new array
        for i in range(l):
            tempMax=max(tempMax,nums[i]) #T.C:O(n)
        arr=[0 for i in range(tempMax+1)]
        #Adding all the same elements and placing them in the sorted order
        for i in range(l):
            arr[nums[i]]=arr[nums[i]]+nums[i]#T.C:O(n)
        #DynamicPRogramming
        skip=0
        take=0
        for i in range(1,tempMax+1):#T.C:O(n)
            temp=skip
            skip=max(skip,take)
            take=temp+arr[i]
        return max(skip,take)
        

        