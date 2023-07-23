# Time - O(n)+O(max(n))
# Space - O(max(n))
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0: 
            return 0        
        arr=[0 for _ in range(max(nums)+1)] #Space - O(max(n))
        for num in nums: #Time - O(n) #array of sum of duplicates. Now, this is a House of robbers problem.
            arr[num]+=num
        prev=arr[0]
        curr=max(arr[0],arr[1])
        for i in range(2,len(arr)): #Time - O(max(n))
            temp=curr
            curr=max(arr[i]+prev,curr)
            prev=temp
        return curr
        