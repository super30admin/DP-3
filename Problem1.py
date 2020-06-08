# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self,nums):
        if not nums or len(nums) == 0 :
            return 0
        max1 = max(nums)
        
        arr = [0] * (max1 + 1)
        for num in nums:
            arr[num] = arr[num] + num
        print(arr)
        
        # skip =0 
        # take = 0 
        # for i in range(1,len(arr)):
        #     temp = skip 
        #     skip = max(skip, take)
        #     take = temp + arr[i]        
        # return max(skip,take)
        small = arr[0] 
        large = max(arr[0],arr[1])
        for i in range(2,len(arr)):
            curr = max(large, small + arr[i])
            small = large 
            large = curr 
        return large 
        

if __name__ == "__main__":
    s = Solution()
    nums = [3,4,2]
    res = s.deleteAndEarn(nums)
    print(res)
