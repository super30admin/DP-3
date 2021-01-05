class Solution:
    '''
    Time Complexity: max(O(max(nums)),O(len(nums))
    Space Complexity. O(max(nums))
    '''
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        sum1 = [0 for i in range(0,max(nums)+1)]
        for i in nums:
            sum1[i] += i
        skip = 0
        take = sum1[0]
        for i in range(1,len(sum1)):
            temp = skip
            skip = max([skip,take])
            take = temp + sum1[i]
        return max([skip,take])
