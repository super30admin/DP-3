#TC - O(n)
#SC - O(1)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        arr = [0]*(max(nums)+1)
        for i in nums:
            arr[i] += i
        rob1,rob2=0,0
        for n in arr:
            temp=max(n+rob1,rob2)
            rob1=rob2
            rob2=temp
        return rob2