# Optimized solution
# Here, the goal is to reduce this problem array to that of the house robber pattern
# We need to do so, as the question says to delete all that occurrences of i-1 and i+ 1
# Without having an aux array, it would be difficult to know where the other frequency of numbers lie in the array
# So transform that given original array into an aux one, where the values accumulated by numbers at index are now continous. 
# Now we can apply same technique as house robber problem


# Time Complexity:  O(N)
# Space Complexity: O(N)

def delete_and_earn(values):
    
    max_val = 0
    aux_arr = [0] * (max(values) + 1)
    
    for num in values:
        aux_arr[num] += num
        
    # reduced to house problem
    
    skip = 0
    take = aux_arr[0]
    
    for i in range(len(aux_arr)):
        temp = skip
        
        skip = max(skip, take)
        take = temp + aux_arr[i]
        
    return max(skip, take)
        
        
    
    
    
print(delete_and_earn([3,4,2]))