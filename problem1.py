class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        modified_nums = [0]*(max(nums)+1)
        for x in nums:
            modified_nums[x] += x
        matrix = [[0]*2 for _ in range(len(modified_nums))]
        for i in range(1, len(modified_nums)):
            #not choosing
            matrix[i][0] = max(matrix[i-1][0], matrix[i-1][1])
            #choosing 
            matrix[i][1] = matrix[i-1][0] + modified_nums[i]
            
        return max(matrix[len(matrix)-1][0], matrix[len(matrix)-1][1])
    

#Time complexity is max(O(n), O(m)) where n is length of nums array whereas m is maximum value in the nums array
#Space complexity is O(n) where n is maximum value in the nums array
#DP approach is used where the nums array was modified to convert the problem similar to house robber problem