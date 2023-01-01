# Time Complexity :O(n)
# Space Complexity :O(max(nums))


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        m=max(nums)
        arr=[0 for i in range(m)]
        for i in nums:
            arr[i-1]+=i
        # print(arr)
        prev,curr=0,0
        for i in arr:
            temp=curr
            curr=max(curr,prev+i)
            prev=temp
        return curr