class Solution:
    '''
    The time complexity for below code is O(2^n)
    The space complexity for below code is O(1)
    Leetcode: Yes was able to do in recursion and DP.
    Issue: None.
    '''
    def helper(self, nums, idx):
        # base
        if idx >= len(nums):
            return 0
        # logic
        case0 = self.helper(nums, idx+1)

        case1 = nums[idx]  + self.helper(nums, idx+2)

        return max(case0, case1)

    def deleteAndEarn(self, nums):
        max_ele = max(nums)
        sum_list = [0] * (max_ele + 1)
        for i in range(len(nums)):
            sum_list[nums[i]] += nums[i]
            
        return self.helper(sum_list, 0)

class Solution:
    '''
    The time complexity for below code is O(2n)
    The space complexity for below code is O(max_num)
    Leetcode: Yes was able to do in recursion and DP.
    Issue: None.
    '''
    def deleteAndEarn(self, nums):
        max_num = max(nums)
        arr = [0] * (max_num+1)
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
        prev = nums[0]
        curr = max(arr[0], arr[1])
        for i in range(2, len(arr)):
            tmp = curr
            curr = max(curr, arr[i] + prev)
            prev = tmp
        
        return curr

s = Solution()
nums = [3,4,2]
print(s.deleteAndEarn(nums))
nums = [2,2,3,3,3,4]
print(s.deleteAndEarn(nums))
