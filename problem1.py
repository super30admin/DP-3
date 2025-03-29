# Problem1: https://leetcode.com/problems/delete-and-earn/

# TC : O(N + M) where N is length of nums array and M is the maximum value in nums

# SC : O(M) where M is the maximum value in nums

# Approach: Dynamic Programming (similar to House Robber problem)
#        1. Create frequency array where index represents the number and value represents total points
#        2. Use dynamic programming to find maximum points possible
#        3. At each step, decide whether to take current number or skip it
       
# On leetcode this code runs: YES


def deleteAndEarn(nums):
    # Find the maximum value in the input array to determine the size of our DP array
    max_num = 0
    for num in nums:
        max_num = max(max_num, num)
    
    # Create an array where index i represents the total sum of all occurrences of number i
    arr = [0] * (max_num + 1)
    for num in nums:
        arr[num] += num  # Add the value at each index equal to the number itself
    
    # Base cases for our dynamic programming approach
    prev = arr[0]  # Maximum points if we end at position 0
    curr = max(arr[0], arr[1])  # Maximum points if we end at position 0 or 1
    
    # Dynamic programming iteration
    for i in range(2, max_num + 1):
        temp = curr  # Store current value before updating
        # Either skip current number (keep curr) or take current number plus value from 2 positions back
        curr = max(curr, arr[i] + prev)
        prev = temp  # Update prev to be the old curr value
    
    # Return the maximum points possible
    return curr

#________________________________________________________________________________________________________________

# TC : O(N) where N is the maximum value in nums

# SC : O(N) for the dictionary/map storage

# Approach: 
# Problem Structure: choosing elements from an array where selecting a number gives you points equal to that number, but prevents you from selecting adjacent numbers (similar to the House Robber problem).
# Frequency Map Creation:
#         build a map where each key is a unique number from the input array
#         The value for each key is the sum of all occurrences of that number (essentially number × frequency)
#         Simultaneously tracks the minimum and maximum values in the array
# Dynamic Programming Principle:
#     For each number i, you have two choices:
#         Take the current number (and its points) plus the maximum points from i-2
#         Skip the current number and keep the maximum points from i-1
#     Similar to the House Robber problem where you can't rob adjacent houses
# DP State Transition:
#         prev maintains the maximum points up to position i-2
#         curr maintains the maximum points up to position i-1
#         At each step, we decide whether to include the current number or not
#         The recurrence relation is: max_points[i] = max(max_points[i-1], max_points[i-2] + points[i])
# Optimization:
#         The algorithm only considers numbers that actually exist in the input array
#         It iterates from the minimum to maximum value found, checking the map for each value
#         If a number doesn't exist in the map, it effectively means there are 0 points for that number

# On leetcode this code runs: YES

def deleteAndEarn(nums):
    # Initialize a dictionary to store frequency/sum of numbers
    map_dict = {}
    
    # Initialize max and min variables
    max_val = float('-inf')
    min_val = float('inf')
    
    # Populate the dictionary and find max and min values
    for num in nums:
        # Get current value for num (default 0) and add num to it
        map_dict[num] = map_dict.get(num, 0) + num
        # Update maximum value seen
        max_val = max(max_val, num)
        # Update minimum value seen
        min_val = min(min_val, num)
    
    # Initialize dynamic programming variables
    prev = map_dict.get(min_val, 0)  # Value at minimum position
    curr = prev
    
    # Check if min+1 exists and update curr if needed
    if min_val + 1 in map_dict:
        curr = max(prev, map_dict.get(min_val + 1, 0))
    
    # Dynamic programming iteration from min+2 to max
    for i in range(min_val + 2, max_val + 1):
        temp = curr  # Store current value before updating
        
        if i in map_dict:
            # If current number exists in map, either skip it or take it plus prev-1 value
            curr = max(curr, map_dict[i] + prev)
        else:
            # If number doesn't exist, just carry forward previous best value
            curr = max(curr, 0 + prev)
        
        prev = temp  # Update prev to be the old curr value
    
    # Return the maximum sum possible
    return curr