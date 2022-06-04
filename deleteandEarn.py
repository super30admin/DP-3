'''
time complexity: O(max(nums))
space complexity: O(1)
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxs = max(nums)
        arr = [ 0 for _ in range(0,maxs+1)]
        
        for n in nums:
            arr[n]+=n
        choose = arr[0]
        notChoose = arr[1]
        
        for i in range(2,len(arr)):
            temp = choose
            choose = max(temp,notChoose)
            notChoose = temp + arr[i]
        return max(choose,notChoose)