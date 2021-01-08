# TC= O(R) R- max value of array
# SC = O(R)
# We create aux array with size of max value of array. at each index we fill the total value of that element in that array. Skip - take variables are used to store previous value which was not considered and previously calculated value. Each step we consider max of these values.
class Solution:
    def deleteAndEarn(self, nums):
        if nums == None or len(nums) == 0:
            return 0
        max_ = max(nums)    
        arr = [0] * (max_+1)
        for num in nums:
            arr[num] += num
        skip, take = 0,0
        for i in range(len(arr)):
            temp = skip
            skip = max(skip, take)
            take = temp + arr[i]
        return max(skip, take)

# Driver code
obj = Solution()
nums = [3, 4, 2]
print(obj.deleteAndEarn(nums))