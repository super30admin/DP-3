class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
    
        points = defaultdict(int)
        max_number = 0
        for num in nums:
            points[num] += num
            max_number = max(max_number, num)
            
        print(points)
        
# Recursion with Memoization
#         memo = {}

#         def max_points(num):
#             # Base cases
            
#             if num in memo:
#                 return memo[num]
            
#             if num == 0:
#                 return 0
#             if num == 1:
#                 return points[1]

#             # Recursive calls: choose max of taking or not taking the current number
#             take = points[num] + max_points(num - 2)
#             not_take = max_points(num - 1)

#             memo[num] = max(take, not_take)
            
#             return memo[num]

#         # Starting the recursion from the maximum number in nums
#         return max_points(max_number)

#Tabulation

        dp = [-1 for _ in range(max_number + 1)]
    
        dp[0] = 0
        dp[1] = points[1]
        
        for i in range(2, max_number + 1):
            
            dp[i] = max(points[i] + dp[i-2], dp[i-1])
            
        return dp[-1]
                
                
                
                
        
            
            
        
