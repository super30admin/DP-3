# Time Complexity: O(max(n))+O(n)
# Space Complexity: O(1)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0: return 0
        arr=[0]*(max(nums)+1)
        for i in nums:
            arr[i]+=i
        if len(arr)==1:
            return arr[0]
        print(arr)
        if len(arr)==2:
            return max(arr[0],arr[1])
        prev_2=arr[0]
        prev_1=max(arr[0],arr[1])
        for i in range(2,len(arr)):
            val=max(prev_1,arr[i]+prev_2)
            prev_2=prev_1
            prev_1=val
        return prev_1