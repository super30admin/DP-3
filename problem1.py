# Time complexity is O(N) and space complexity is O(1)
class Solution:
    def deleteAndEarn(self, nums):
        count = Counter(nums)
        nums = sorted(list(set(nums)))
        
        e1 =0
        e2 = 0
        
        for i in range(len(nums)):
            ce = nums[i]*count[nums[i]]
            
            if i > 0 and nums[i-1]+1 == nums[i]:
                temp = e2
                e2 = max(e2, e1+ce)
                e1 = temp
            else:
                temp= e2
                e2 = e2+ce
                e1 = temp
        return e2